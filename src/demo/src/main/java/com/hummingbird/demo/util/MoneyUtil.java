package com.hummingbird.demo.util;

import java.text.DecimalFormat;

/**
 * 金额工具类,用于paas项目
 * @author john huang
 * 2015年11月14日 上午11:43:07
 * 本类主要做为
 */
public class MoneyUtil extends com.hummingbird.common.util.MoneyUtil{
	
	/**
	 * 把分转化为元
	 * @param price
	 * @return
	 */
	public static String getMoneyStringDecimal4yuan(Number price){
		if(price==null){
			return null;
		}
		
		return new DecimalFormat("0.00").format((double)(price.doubleValue()/100));
	}
	
	
}
