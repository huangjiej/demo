/**
 * 
 * TestVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.demo.vo;

/**
 * @author john huang
 * 2015年12月10日 下午5:01:04
 * 这是样例,没有什么作用
 */
public class TestVO {

	/**
	 * 呼叫内容
	 */
	private String hello;

	/**
	 * 呼叫内容 
	 */
	public String getHello() {
		return hello;
	}

	/**
	 * 呼叫内容 
	 */
	public void setHello(String hello) {
		this.hello = hello;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestVO [hello=" + hello + "]";
	}
	
}
