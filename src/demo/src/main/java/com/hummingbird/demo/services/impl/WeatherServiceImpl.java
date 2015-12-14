package com.hummingbird.demo.services.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
		WeatherBodyVOResult result = new WeatherBodyVOResult();
		String url = "http://api.map.baidu.com/telematics/v3/weather";
		Map<String,String> params = new HashMap<String, String>(); 
		//开发者密钥
		params.put("ak", "GgS4VK9Ci9MgoUx6E6I5MkwB");
		//输出的数据格式json
		params.put("output", "json");
		//城市名称
		params.put("location", city);
		//type=true以rest风格传递参数，type=false以&拼接参数
		boolean type = false;
		HttpProcessUtil httpProCessUtil = new HttpProcessUtil();
		
		try {
			byte[] bytes = httpProCessUtil.doGet(url, params, type);
			String responseBody = new String(bytes, "UTF-8");
			JSONObject json = JSONObject.fromObject(responseBody);
			System.out.println(json);
			//{"date":"2015-12-14","error":0,
			//"results":[ 
			     //{"weather_data":[
			 //{"date":"周一 12月14日 (实时：19℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","temperature":"24 ~ 14℃","wind":"微风"},
			//{"date":"周二","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","temperature":"19 ~ 12℃","wind":"微风"},
			//{"date":"周三","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"多云转晴","temperature":"15 ~ 10℃","wind":"东北风5-6级"},
			//{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","temperature":"15 ~ 10℃","wind":"东北风4-5级"}
			// ],"pm25":"38","index":
			//[{"des":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","zs":"较舒适","title":"穿衣","tipt":"穿衣指数"},{"des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","zs":"较适宜","title":"洗车","tipt":"洗车指数"},{"des":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。","zs":"适宜","title":"旅游","tipt":"旅游指数"},{"des":"天冷风大，易发生感冒，请注意适当增加衣服，加强自我防护避免感冒。","zs":"易发","title":"感冒","tipt":"感冒指数"},{"des":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。","zs":"适宜","title":"运动","tipt":"运动指数"},{"des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。","zs":"弱","title":"紫外线强度","tipt":"紫外线强度指数"}],
			//"currentCity":"深圳"}],"status":"success"}
			String temperature = json.getString("temperature");
			String[] temper = temperature.split("~");
			int minTemperature = json.getInt("minTemperature");
			int maxTemperature = json.getInt("maxTemperature");
			String weatherCondition = json.getString("weather");
			
			//获取当前日期  
            Date date = new Date();  
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");  
            String nowDate = sf.format(date);  
            //通过日历获取下一天日期  
            Calendar cal = Calendar.getInstance();  
            cal.setTime(sf.parse(nowDate));  
            cal.add(Calendar.DAY_OF_YEAR, +1);  
            Date tomorrowDate = cal.getTime();
            String tomorrow = sf.format(cal.getTime());  
            
			result.setCityName(city);
			result.setMinTemperature(minTemperature);
			result.setMaxTemperature(maxTemperature);
			result.setWeather(weatherCondition);
			result.setDate(tomorrow);
			
			//保存明天的天气到数据库
			Weather weather = new Weather();
			weather.setCity(city);
			weather.setMinTemperature(minTemperature);
			weather.setMaxTemperature(maxTemperature);
			weather.setWeatherDay(tomorrowDate);
			weather.setWeather(weatherCondition);
			
			weatherDao.insertSelective(weather);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		
		if(log.isDebugEnabled()){
				log.debug("查询城市天气完成");
		}
		return result;
	}
		
		
		
}