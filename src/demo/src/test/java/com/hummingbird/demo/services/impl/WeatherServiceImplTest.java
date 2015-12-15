package com.hummingbird.demo.services.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.demo.util.HttpProcessUtil;
import com.hummingbird.demo.vo.WeatherBodyVO;
import com.hummingbird.demo.vo.WeatherBodyVOResult;

import net.sf.json.JSONObject;

public class WeatherServiceImplTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryWeather() {
		String url = "http://api.map.baidu.com/telematics/v3/weather";
		Map<String,String> params = new HashMap<String, String>(); 
		//开发者密钥s
		params.put("ak", "GgS4VK9Ci9MgoUx6E6I5MkwB");
		//输出的数据格式json
		params.put("output", "json");
		//城市名称
		params.put("location", "深圳");
		//type=true以rest风格传递参数，type=false以&拼接参数
		boolean type = false;
		HttpProcessUtil httpProCessUtil = new HttpProcessUtil();
		try {
				byte[] bytes = httpProCessUtil.doGet(url, params, type);
				
				assertNotNull(bytes);
				
				String responseBody = new String(bytes, "UTF-8");
				JSONObject jsonObject = JSONObject.fromObject(responseBody);
				String status = jsonObject.getString("status");
				assertEquals("success", status);
				int error = jsonObject.getInt("error");
				assertEquals(0, error);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
