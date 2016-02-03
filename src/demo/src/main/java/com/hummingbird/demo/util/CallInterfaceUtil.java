package com.hummingbird.demo.util;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.hummingbird.common.util.PropertiesUtil;


/**
 * 接口调用
 * @ClassName: CallInterfaceUtil 
 * @author dingxuefei
 * @date 2015年11月21日 下午2:45:24 
 *
 */
public class CallInterfaceUtil {

	private static Gson gson = new Gson();
	
	private static final Log log = LogFactory.getLog(CallInterfaceUtil.class);
	private static String root_url = "";
	
	static {
		PropertiesUtil pu = new PropertiesUtil();
		root_url = pu.getProperty("call.interface.url");
	}
	
	
	
	
	
	
	/**
	 * 查询标签接口
	 * @param tagGroupName  组名称
	 * @param tagObjectCode   标签的所属业务编码
	 * @param businessId  被打标签信息的ID
	 * @return
	 */
	public static String searchTag(String tagGroupName, String tagObjectCode, Integer businessId){
		if(StringUtils.isBlank(tagGroupName)){
			log.debug("标签的组名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的组名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagObjectCode)){
			log.debug("标签的所属业务编码为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的所属业务编码为空\"}";	
    	}
		if(businessId == null){
			log.debug("被打标签信息的ID为空");
    		return "{\"errcode\":10000,\"errmsg\":\"被打标签信息的ID为空\"}";	
    	}
		
		String url = root_url+"/tag/searchTag";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagGroupName", tagGroupName);
		jsonObject.put("tagObjectCode", tagObjectCode);
		jsonObject.put("businessId", businessId);
		
		String param = jsonObject.toString();
		log.debug("查询标签接口发送参数："+param);
		String result = "";
		try {
			result = HttpPostUtils.sendHttpPost(url, param);
			log.debug("查询标签接口返回值："+result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			return "{\"errcode\":10000,\"errmsg\":\""+result+"\"}";	 //错误返回
		}
	}
	

	/**
	 * 查询标签接口
	 * @param tagGroupName  组名称
	 * @param tagObjectCode   标签的所属业务编码
	 * @param businessId  被打标签信息的ID
	 * @return
	 */
	public static String searchTag(String tagGroupName, String tagObjectCode, String businessId){
		if(StringUtils.isBlank(tagGroupName)){
			log.debug("标签的组名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的组名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagObjectCode)){
			log.debug("标签的所属业务编码为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的所属业务编码为空\"}";	
    	}
		if(businessId == null){
			log.debug("被打标签信息的ID为空");
    		return "{\"errcode\":10000,\"errmsg\":\"被打标签信息的ID为空\"}";	
    	}
		
		String url = root_url+"/tag/searchTag";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagGroupName", tagGroupName);
		jsonObject.put("tagObjectCode", tagObjectCode);
		jsonObject.put("businessId", businessId);
		
		String param = jsonObject.toString();
		log.debug("查询标签接口发送参数："+param);
		String result = "";
		try {
			result = HttpPostUtils.sendHttpPost(url, param);
			log.debug("查询标签接口返回值："+result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			return "{\"errcode\":10000,\"errmsg\":\""+result+"\"}";	 //错误返回
		}
	}
	
	
	/**
	 * 移除标签
	 * @param tagName  标签名称
	 * @param tagCreateObject   标签的创建者
	 * @param tagGroupName   组名称
	 * @param tagObjectCode  标签的所属业务编码
	 * @param businessId  被打标签的信息ID
	 * @return
	 */
	public static String removeTag(String tagName, String tagCreateObject, String tagGroupName, String tagObjectCode, Integer businessId){
		if(StringUtils.isBlank(tagGroupName)){
			log.debug("标签的组名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的组名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagObjectCode)){
			log.debug("标签的所属业务编码为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的所属业务编码为空\"}";	
    	}
		if(businessId == null){
			log.debug("被打标签信息的ID为空");
    		return "{\"errcode\":10000,\"errmsg\":\"被打标签信息的ID为空\"}";	
    	}
		if(StringUtils.isBlank(tagName)){
			log.debug("标签名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagCreateObject)){
			log.debug("标签的创建者为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的创建者为空\"}";	
    	}
		
		String url = root_url+"/tag/cancelTag";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagName", tagName);
		jsonObject.put("tagCreateObject", tagCreateObject);
		jsonObject.put("tagGroupName", tagGroupName);
		jsonObject.put("tagObjectCode", tagObjectCode);
		jsonObject.put("businessId", businessId);
		
		String param = jsonObject.toString();
		log.debug("移除标签接口发送参数："+param);
		String result = "";
		try {
			result = HttpPostUtils.sendHttpPost(url, param);
			log.debug("移除标签接口返回值："+result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			return "{\"errcode\":10000,\"errmsg\":\""+result+"\"}";	 //错误返回
		}
	}
	
	/**
	 * 调用添加标签接口
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @param tagGroupName  组名称
	 * @param tagObjectCode  标签的所属业务编码
	 * @param businessId  被打标签信息的ID
	 * @param url  接口地址
	 */
	public static String addTag(String tagName, String tagCreateObject, String tagGroupName, String tagObjectCode, String businessId){
		
		if(StringUtils.isBlank(tagName)){
			log.debug("标签名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签名称为空\"}";
    	}
		if(StringUtils.isBlank(tagCreateObject)){
			log.debug("标签的创建者为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的创建者为空\"}";	
    	}
		if(StringUtils.isBlank(tagGroupName)){
			log.debug("标签的组名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的组名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagObjectCode)){
			log.debug("标签的所属业务编码为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的所属业务编码为空\"}";	
    	}
		if(businessId == null){
			log.debug("被打标签信息的ID为空");
    		return "{\"errcode\":10000,\"errmsg\":\"被打标签信息的ID为空\"}";	
    	}
		
		String url = root_url+"/tag/insert";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagName", tagName);
		jsonObject.put("tagCreateObject", tagCreateObject);
		jsonObject.put("tagGroupName", tagGroupName);
		jsonObject.put("tagObjectCode", tagObjectCode);
		jsonObject.put("businessId", businessId);
		
		String param = jsonObject.toString();
		log.debug("添加标签接口发送参数："+param);
		String result = "";
		try {
			result = HttpPostUtils.sendHttpPost(url, param);
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		log.debug("添加标签接口返回值："+result);
		return result;
	}
	/**
	 * 调用添加标签接口
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @param tagGroupName  组名称
	 * @param tagObjectCode  标签的所属业务编码
	 * @param businessId  被打标签信息的ID
	 * @param url  接口地址
	 */
	public static String addTag(String tagName, String tagCreateObject, String tagGroupName, String tagObjectCode, Integer businessId){
		
		if(StringUtils.isBlank(tagName)){
			log.debug("标签名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签名称为空\"}";
    	}
		if(StringUtils.isBlank(tagCreateObject)){
			log.debug("标签的创建者为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的创建者为空\"}";	
    	}
		if(StringUtils.isBlank(tagGroupName)){
			log.debug("标签的组名称为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的组名称为空\"}";	
    	}
		if(StringUtils.isBlank(tagObjectCode)){
			log.debug("标签的所属业务编码为空");
    		return "{\"errcode\":10000,\"errmsg\":\"标签的所属业务编码为空\"}";	
    	}
		if(businessId == null){
			log.debug("被打标签信息的ID为空");
    		return "{\"errcode\":10000,\"errmsg\":\"被打标签信息的ID为空\"}";	
    	}
		
		String url = root_url+"/tag/insert";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagName", tagName);
		jsonObject.put("tagCreateObject", tagCreateObject);
		jsonObject.put("tagGroupName", tagGroupName);
		jsonObject.put("tagObjectCode", tagObjectCode);
		jsonObject.put("businessId", businessId);
		
		String param = jsonObject.toString();
		log.debug("添加标签接口发送参数："+param);
		String result = "";
		try {
			result = HttpPostUtils.sendHttpPost(url, param);
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		log.debug("添加标签接口返回值："+result);
		return result;
	}
	
}
