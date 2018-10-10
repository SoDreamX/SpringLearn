package com.sxh.spring.testAop;

public class CutPointLog {
	public void beforeMethod() {
		System.out.println("方法开始日志========");
	}
	public void afterMethod() {
		System.out.println("方法结束日志========");
	}
}
