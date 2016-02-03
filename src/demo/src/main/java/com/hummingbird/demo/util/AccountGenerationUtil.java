package com.hummingbird.demo.util;

import java.util.Random;

import com.hummingbird.common.util.DateUtil;

public class AccountGenerationUtil {
	/**
	 * 创建资金账号
	 * @return
	 */
	public static String genAmountOrderAccountNo(){
		return genNO("CA");
	}
	
	public static String genNO(String prefix){
		return prefix+DateUtil.getCurrentTimeStr() + String.format("%014d", new Random().nextInt(999999999));
	}
	public static String genNO(String prefix,int len){
		return prefix+DateUtil.getCurrentTimeStr() + String.format("%"+len+"d", new Random().nextInt(999999999));
	}
	public static void main(String[] args) {
		System.out.println(genNO("RM00"));
	}
}
