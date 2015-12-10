/**
 * 
 * MaAccountException.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.demo.exception;

import com.hummingbird.common.exception.BusinessException;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午10:07:38
 * 本类主要做为招标管理的异常
 */
public class TenderException extends PaasException {

	public TenderException() {
		super();
		this.errcode = super.ERR_TENDER_INFO_EXCEPTION;
	}

	public TenderException(int errcode, String message, Throwable cause) {
		super(errcode, message, cause);
	}

	public TenderException(int errcode, String message) {
		super(errcode, message);
	}

	public TenderException(String message, Throwable cause) {
		super(message, cause);
		this.errcode = super.ERR_TENDER_INFO_EXCEPTION;
	}

	public TenderException(String message) {
		super(message);
		this.errcode = super.ERR_TENDER_INFO_EXCEPTION;
	}

	public TenderException(Throwable cause) {
		super(cause);
		this.errcode = super.ERR_TENDER_INFO_EXCEPTION;
	}

}
