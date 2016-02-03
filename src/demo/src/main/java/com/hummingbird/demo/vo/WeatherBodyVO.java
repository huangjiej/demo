package com.hummingbird.demo.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 查询城市天气 在body VO
 */
public class WeatherBodyVO
implements PainttextAble {

    	    	/**
	     * 
	     */
	    protected String city;
	
	    	/**
	     * @return 
	     */
	    public String getCity() {
	        return city;
	    }
	
	    /**
	     * @param 
	     */
	    public void setCity(String city) {
	        this.city = city;
	    }
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(city) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}