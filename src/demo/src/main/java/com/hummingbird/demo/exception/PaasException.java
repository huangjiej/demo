/**
 * 
 * PaasException.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.demo.exception;

import com.hummingbird.common.exception.BusinessException;

/**
 * @author john huang
 * 2015年11月11日 下午2:48:36
 * 本类主要做为
 */
public class PaasException extends BusinessException {
	
	/**
	 * 招标信息异常
	 */
	static public int ERR_TENDER_INFO_EXCEPTION=1;
	/**
	 * 招标人异常
	 */
	static public int ERR_BIDDEE_INFO_EXCEPTION=2;
	/**
	 * 投标人异常
	 */
	static public int ERR_BIDDER_INFO_EXCEPTION=3;
	/**
	 * 投标异常
	 */
	static public int ERR_BID_INFO_EXCEPTION=4;
	/**
	 * 投标资质证书异常
	 */
	static public int ERR_BID_CERTIFICATION_INFO_EXCEPTION=5;
	/**
	 * 会员异常
	 */
	static public int ERR_MEMBER_INFO_EXCEPTION=6;
	/**
	 * 用户通知异常
	 */
	static public int ERR_USER_NOTICE_INFO_EXCEPTION=7;
	
	/**
	 * 用户信息异常
	 */
	static public int ERR_USER_INFO_EXCEPTION=8;
		
	

	public PaasException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaasException(int errcode, String message, Throwable cause) {
		super(errcode, message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaasException(int errcode, String message) {
		super(errcode, message);
		// TODO Auto-generated constructor stub
	}

	public PaasException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaasException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaasException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
