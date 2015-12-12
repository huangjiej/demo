package com.hummingbird.demo.services;

import java.util.List;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.demo.vo.WeatherBodyVOResult;


/**
 * @author 
 * @date 2015-12-12
 * @version 1.0
 *  service接口
 */
public interface WeatherService  {

			/**
	 * 查询城市天气
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public WeatherBodyVOResult queryWeather(String appId,WeatherBodyVO body) throws BusinessException;
		
		
	}