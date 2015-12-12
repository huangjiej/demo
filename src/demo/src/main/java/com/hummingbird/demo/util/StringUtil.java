package com.hummingbird.demo.util;

import org.apache.commons.lang.StringUtils;

import com.hummingbird.common.exception.BusinessException;

/**
 * String工具类,用于paas项目
 * @author YJY
 * 2015年11月28日18:04:53
 * 本类主要做为
 */
public class StringUtil {
	
	/**
	 *	银行卡号或者姓名 电话=部分展示
	 * @author YJY
	 * @since  2015年11月28日17:41:30
	 * @param T
	 *           
	 * @return String
	 * @throws BusinessException
	 */
	public String getShowString(String str) throws BusinessException {
		// TODO Auto-generated method stub
		String ss = "";
        if(org.apache.commons.lang.StringUtils.isNotBlank(str)){
        	if(StringUtils.isNumeric(str)){//银行卡或者身份证
        		if(str.length()>15){
        			ss = str.substring(0, 4)+"******"+str.substring(str.length()-4);
        		}else if(str.length()>2){
        			ss = str.substring(0, 1)+"*"+str.substring(str.length()-1);
        		}else if(str.length()>1){
        			ss = "*"+str.substring(str.length()-1);
        		}
        	}else{//其他  姓名
        		if(str.length()>2){
        			ss = str.substring(0, 1)+"*"+str.substring(str.length()-1);
        		}else if(str.length()>1){
        			ss = "*"+str.substring(str.length()-1);
        		}
        	}
        	
        }
		
		
		return ss;
	}
	
}
