package com.hummingbird.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.demo.services.AppInfoService;

/**
 * @author john huang
 * 2015年12月10日 下午4:59:08
 * 这是一个样例性的代码,并无实际意义,请不要在此代码上进行开发
 */
@Controller

@RequestMapping("/test")
public class AppController extends BaseController{
	@Autowired 
	AppInfoService appSrv;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@AccessRequered(methodName = "样例接口", isJson = true, codebase = 200100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.demo.vo.TestVO", appLog = false)
	public @ResponseBody ResultModel queryMyObjectTenderSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
		BaseTransVO<com.hummingbird.demo.vo.TestVO> transorder = (BaseTransVO<com.hummingbird.demo.vo.TestVO>) super.getParameterObject();
		String messagebase = "我的招标评标概况接口";

		RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求

		try {
			// 业务数据必填等校验
			
			// 业务数据逻辑校验
			if (log.isDebugEnabled()) {
				log.debug("检验通过，获取请求");
			}
//			appSrv.validate(transorder.getApp());  //业务逻辑处理
			rm.put("result", "hello,"+transorder.getBody().getHello());
		} catch (Exception e1) {
			//捕捉异常,不让返回出错
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if (qe != null)
				qe.setSuccessed(false);
		} finally {
			if (qe != null){
				//事件触发
				EventListenerContainer.getInstance().fireEvent(qe);
			}
		}
		return rm;

	}
	
}
