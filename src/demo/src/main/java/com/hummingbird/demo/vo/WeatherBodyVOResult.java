package com.hummingbird.demo.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询城市天气 结果输出 VO
 */
public class WeatherBodyVOResult
{
    	    	/**
	     * 
	     */
	    protected String cityName;
	    	/**
	     * 最高温度
	     */
	    protected Integer minTemperature;
	    	/**
	     * 最低温度
	     */
	    protected Integer maxTemperature;
	    	/**
	     * 天气情况
	     */
	    protected String weather;
	    	/**
	     *明天的时间,年-月-日
	     */
	    protected String date;
	
	    	/**
	     * @return 
	     */
	    public String getCityName() {
	        return cityName;
	    }
	
	    /**
	     * @param 
	     */
	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }
	    	/**
	     * @return 最高温度
	     */
	    public Integer getMinTemperature() {
	        return minTemperature;
	    }
	
	    /**
	     * @param 最高温度
	     */
	    public void setMinTemperature(Integer minTemperature) {
	        this.minTemperature = minTemperature;
	    }
	    	/**
	     * @return 最低温度
	     */
	    public Integer getMaxTemperature() {
	        return maxTemperature;
	    }
	
	    /**
	     * @param 最低温度
	     */
	    public void setMaxTemperature(Integer maxTemperature) {
	        this.maxTemperature = maxTemperature;
	    }
	    	/**
	     * @return 天气情况
	     */
	    public String getWeather() {
	        return weather;
	    }
	
	    /**
	     * @param 天气情况
	     */
	    public void setWeather(String weather) {
	        this.weather = weather;
	    }
	    	/**
	     * @return 当前时间,年-月-日
	     */
	    public String getDate() {
	        return date;
	    }
	
	    /**
	     * @param 当前时间,年-月-日
	     */
	    public void setDate(String date) {
	        this.date = date;
	    }
	
    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}