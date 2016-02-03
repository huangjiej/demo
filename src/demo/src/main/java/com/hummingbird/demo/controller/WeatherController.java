package com.hummingbird.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.demo.services.WeatherService;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.demo.vo.WeatherBodyVOResult;


/**
 * @author 
 * @date 2015-12-12
 * @version 1.0
 *  
 */
@Controller
@RequestMapping(value="weather",method=RequestMethod.POST)
public class WeatherController extends BaseController {
	@Autowired(required = true)
	protected WeatherService weatherService;
		
	/**
	 * 查询城市天气
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/queryTomorrowWeather",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询城市天气",isJson=true,codebase=210100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.demo.vo.WeatherBodyVO",appLog=true)
	public @ResponseBody ResultModel queryWeather(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<WeatherBodyVO> transorder = (BaseTransVO<WeatherBodyVO>) super.getParameterObject();
		String messagebase = "查询城市天气"; 
		try {
				//业务数据逻辑校验
				if(log.isDebugEnabled()){
					log.debug("检验通过，获取请求");
				}
				WeatherBodyVOResult  result = weatherService.queryWeather(transorder.getApp().getAppId(),transorder.getBody());
				rm.setErrcode(0);
				rm.setErrmsg(messagebase + "成功");
				rm.put("result",result);
		}catch (BusinessException e) {
			log.error(String.format(messagebase + "失败"), e);
			rm.setErrcode(10000);
			rm.setErrmsg(messagebase + "失败");
			rm.mergeException(e);
		}catch (Exception e) {
			log.error(String.format(messagebase + "失败"), e);
			rm.setErrcode(10000);
			rm.setErrmsg(messagebase + "失败");
			rm.mergeException(e);
		} 
		return rm;
		
	}
 }
