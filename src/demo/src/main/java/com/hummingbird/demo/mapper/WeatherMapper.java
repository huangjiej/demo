package com.hummingbird.demo.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.hummingbird.demo.entity.Weather;

public interface WeatherMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id)throws DataAccessException;

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Weather record)throws DataAccessException;

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Weather record)throws DataAccessException;

    /**
     * 根据主键查询记录
     */
    Weather selectByPrimaryKey(Integer id)throws DataAccessException;

    /**
     * 根据城市和日期查询记录
     */
    Weather selectByCityAndDate(Weather weather)throws DataAccessException;
    
    /**
     * 查询记录
     */
    Weather selectWeather(@Param("city")String city,@Param("weatherDay")Date weatherDay)throws DataAccessException;
    
    
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Weather record)throws DataAccessException;

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Weather record)throws DataAccessException;
}