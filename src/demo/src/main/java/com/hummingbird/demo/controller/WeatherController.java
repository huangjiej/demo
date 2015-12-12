package com.hummingbird.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.demo.services.WeatherService;



import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.demo.entity.Token;
import com.hummingbird.demo.services.TokenService;

import com.hummingbird.commonbiz.vo.BaseTransVO;
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
//	@Autowired
//	TokenService tokenSrv;
		
	/**
	 * 查询城市天气
	 * @return
	 */
	@RequestMapping(value="/queryWeather",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询城市天气",isJson=true,codebase=210100,className="com.hummingbird.commonbiz.vo.BaseTransVO",genericClassName="com.hummingbird.demo.vo.WeatherBodyVO",appLog=true)
	public @ResponseBody ResultModel queryWeather(HttpServletRequest request,HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<WeatherBodyVO> transorder = (BaseTransVO<WeatherBodyVO>) super.getParameterObject();
		String messagebase = "查询城市天气"; 
	
		RequestEvent qe=null ; //业务请求事件,当实现一些关键的业务时,需要生成该请求
		
		try {
			//业务数据必填等校验
//			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
//			if (token == null) {
//				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
//				throw new TokenException("token验证失败,或已过期,请重新登录");
//			}
//			validateWithBusiness(transorder.getBody().getToken(), transorder.getApp().getAppId(),token);
			//业务数据逻辑校验
			if(log.isDebugEnabled()){
				log.debug("检验通过，获取请求");
			}
						WeatherBodyVOResult  result = weatherService.queryWeather(transorder.getApp().getAppId(),transorder.getBody());
			rm.put("",result);
						//tokenSrv.postponeToken(token);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	
    }
