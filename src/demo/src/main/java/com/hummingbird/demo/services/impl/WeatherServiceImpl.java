package com.hummingbird.demo.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.demo.mapper.WeatherMapper;
import com.hummingbird.demo.services.WeatherService;
import com.hummingbird.demo.util.HttpProcess;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.demo.vo.WeatherBodyVOResult;

/**
 * @author 
 * @date 2015-12-12
 * @version 1.0
 *  service接口实现
 */
@Service
public class WeatherServiceImpl  implements WeatherService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired(required = true)
    HttpProcess httpProcess;
	@Autowired
	WeatherMapper dao;

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
		WeatherBodyVOResult result = new WeatherBodyVOResult();
		String url = "";
		Map<String,String> params = new HashMap<String, String>(); 
		boolean type = true;
		httpProcess.doGet(url, params, type);
		if(log.isDebugEnabled()){
				log.debug("查询城市天气完成");
		}
		return result;
	}
		
		
		
}