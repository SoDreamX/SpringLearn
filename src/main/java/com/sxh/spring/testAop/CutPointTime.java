package com.sxh.spring.testAop;

public class CutPointTime {
	public void beforeMethod() {
		System.out.println("方法开始时间："+System.currentTimeMillis());
	}
	public void afterMethod() {
		System.out.println("方法结束时间："+System.currentTimeMillis());
	}
}
