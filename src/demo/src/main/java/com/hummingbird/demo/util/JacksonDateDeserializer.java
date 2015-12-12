/**
 * 
 * JacksonDateSerializer.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.demo.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.DateUtil;

/**
 * @author john huang
 * 2015年7月9日 下午6:04:40
 * 本类主要做为 转换字符串到日期yyyy-MM-dd
 * 使用方法为,在vo中的getter方法前面加上
 * @JsonDeserialize(using = JacksonDateDeserializer.class)
 */
public class JacksonDateDeserializer extends JsonDeserializer<Date> {


	/* (non-Javadoc)
	 * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser, org.codehaus.jackson.map.DeserializationContext)
	 */
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String text = jp.getText();
		if(StringUtils.isBlank(text)){
			return null;
		}
		Date parseDate;
		try {
			parseDate = DateUtils.parseDate(text, new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
		} catch (ParseException e) {
			throw new IOException("把内容["+text+"]转为日期出错",e);
		}
		return parseDate;
	} 
}
