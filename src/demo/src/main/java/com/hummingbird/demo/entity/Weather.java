package com.hummingbird.demo.entity;

import java.util.Date;

/**
 * 天气表
 */
public class Weather {
    private Integer id;

    /**
     * 城市
     */
    private String city;

    /**
     * 预报日期
     */
    private Date weatherDay;

    /**
     * 最低温度
     */
    private Integer minTemperature;

    /**
     * 最高温度
     */
    private Integer maxTemperature;

    /**
     * 天气
     */
    private String weather;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city 
	 *            城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return 预报日期
     */
    public Date getWeatherDay() {
        return weatherDay;
    }

    /**
     * @param weatherDay 
	 *            预报日期
     */
    public void setWeatherDay(Date weatherDay) {
        this.weatherDay = weatherDay;
    }

    /**
     * @return 最低温度
     */
    public Integer getMinTemperature() {
        return minTemperature;
    }

    /**
     * @param minTemperature 
	 *            最低温度
     */
    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * @return 最高温度
     */
    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * @param maxTemperature 
	 *            最高温度
     */
    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * @return 天气
     */
    public String getWeather() {
        return weather;
    }

    /**
     * @param weather 
	 *            天气
     */
    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Weather other = (Weather) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getWeatherDay() == null ? other.getWeatherDay() == null : this.getWeatherDay().equals(other.getWeatherDay()))
            && (this.getMinTemperature() == null ? other.getMinTemperature() == null : this.getMinTemperature().equals(other.getMinTemperature()))
            && (this.getMaxTemperature() == null ? other.getMaxTemperature() == null : this.getMaxTemperature().equals(other.getMaxTemperature()))
            && (this.getWeather() == null ? other.getWeather() == null : this.getWeather().equals(other.getWeather()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getWeatherDay() == null) ? 0 : getWeatherDay().hashCode());
        result = prime * result + ((getMinTemperature() == null) ? 0 : getMinTemperature().hashCode());
        result = prime * result + ((getMaxTemperature() == null) ? 0 : getMaxTemperature().hashCode());
        result = prime * result + ((getWeather() == null) ? 0 : getWeather().hashCode());
        return result;
    }
}