package com.hummingbird.demo.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.demo.entity.Weather;
import com.hummingbird.demo.mapper.WeatherMapper;
import com.hummingbird.demo.services.WeatherService;
import com.hummingbird.demo.util.HttpProcessUtil;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.demo.vo.WeatherBodyVOResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 
 * @date 2015-12-12
 * @version 1.0
 *  service接口实现
 */
@Service
public class WeatherServiceImpl  implements WeatherService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	WeatherMapper weatherDao;

	/**
	 * 查询城市天气
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public WeatherBodyVOResult queryWeather(String appId,WeatherBodyVO body) throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("查询城市天气开始");
		}
		String city = body.getCity();
		if(StringUtils.isBlank(city)){
			log.error( "城市名称不能为空");
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "城市名称不能为空");
		}
		city = city.replaceAll(" ", "");
		String url = "http://api.map.baidu.com/telematics/v3/weather";
		Map<String,String> params = new HashMap<String, String>(); 
		//开发者密钥s
		params.put("ak", "GgS4VK9Ci9MgoUx6E6I5MkwB");
		//输出的数据格式json
		params.put("output", "json");
		//城市名称
		params.put("location", city);
		//type=true以rest风格传递参数，type=false以&拼接参数
		boolean type = false;
		HttpProcessUtil httpProCessUtil = new HttpProcessUtil();
		WeatherBodyVOResult result = new WeatherBodyVOResult();
		try {
			byte[] bytes = httpProCessUtil.doGet(url, params, type);
			String responseBody = new String(bytes, "UTF-8");
			JSONObject jsonObject = JSONObject.fromObject(responseBody);
			String status = jsonObject.getString("status");
			int error = jsonObject.getInt("error");
			if(error == -2){
				throw new BusinessException("查询天气的城市名称不能为空。");
			}else if(error == -3){
				throw new BusinessException("未查询到[【"+city+"】的天气信息，请输入正确的城市名称。");
			}else{
				//查询天气成功
				if("success".equals(status)){
					    //解析json
					    result = parseJson(jsonObject);
					    
					    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
				        Calendar cal = Calendar.getInstance();  
						cal.setTime(sf.parse(result.getDate()));
				        Date tomorrowDate = cal.getTime();
				        
						Weather weather = new Weather();
						weather.setCity(result.getCityName());
						weather.setMinTemperature(result.getMinTemperature());
						weather.setMaxTemperature(result.getMaxTemperature());
				        weather.setWeatherDay(tomorrowDate);
						weather.setWeather(result.getWeather());
						
						Weather oldWeather = new Weather();
						oldWeather.setCity(result.getCityName());
						oldWeather.setWeatherDay(tomorrowDate);
						//根据城市和日期查询天气
						oldWeather = weatherDao.selectByCityAndDate(oldWeather);
						if(oldWeather!= null && oldWeather.getId()!=null){
							//更新明天的天气
							weather.setId(oldWeather.getId());
							weatherDao.updateByPrimaryKey(weather);
						}else{
							//保存明天的天气到数据库
							weatherDao.insertSelective(weather);
						}
				}
			}
		}catch (DataAccessException e) {
			throw new BusinessException("保存天气信息失败。");
		}catch (BusinessException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
		if(log.isDebugEnabled()){
				log.debug("查询城市天气完成");
		}
		return result;
	}
		
	 
	private WeatherBodyVOResult parseJson(JSONObject jsonObject) throws BusinessException{
			WeatherBodyVOResult result = new WeatherBodyVOResult();
		 try {
			String currentDate = jsonObject.getString("date");
			//当前时间
			//String currentDate = jsonObject.getString("date");
			 JSONArray results = jsonObject.getJSONArray("results");
			 JSONObject jo = (JSONObject) results.get(0);
			 //当前城市
			 String currentCity = jo.getString("currentCity");
			 JSONArray weatherData = jo.getJSONArray("weather_data");
		     //取第二天的天气
		     JSONObject tomorrowWeather = weatherData.getJSONObject(1);
			 //周四
			 // String week = tomorrowWeather.getString("date");
		     //微风
			 //String wind = tomorrow.getString("wind");
			 //晴转多云
			 String weather = tomorrowWeather.getString("weather");
			//25 ~ 15℃
			String temperature = tomorrowWeather.getString("temperature");
			int minTemperature=0,maxTemperature=0;
			if(!temperature.contains("℃")){
				throw new BusinessException("获取温度信息失败");
			}else{
				temperature = temperature.replaceAll(" ", "").replaceAll("℃", "");
				System.out.println(temperature);
				String[] tempers = temperature.split("~");
				if(temperature.contains("~") && tempers.length == 2){
					 maxTemperature= Integer.parseInt(tempers[0]);
					 minTemperature = Integer.parseInt(tempers[1]);
				}else{
					maxTemperature = Integer.parseInt(tempers[0]);
					minTemperature = maxTemperature;
				}
			}	
			 //通过日历获取下一天日期  
			 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
            Calendar cal = Calendar.getInstance();  
			cal.setTime(sf.parse(currentDate));
            cal.add(Calendar.DAY_OF_YEAR, +1);  
            String tomorrow = sf.format(cal.getTime());  
		
			result.setCityName(currentCity);
			result.setMinTemperature(minTemperature);
			result.setMaxTemperature(maxTemperature);
			result.setWeather(weather);
			result.setDate(tomorrow);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new BusinessException("解析日期失败");
			}  catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException("解析天气信息失败");
		    }  
			return result;
			
		}
}