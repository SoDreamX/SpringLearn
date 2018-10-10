package com.sxh.spring.testAop;

public class PrintImpl2 implements PrintInterface {

	@Override
	public void printInfo() {
		System.out.println("PrintImpl2===============printInfo()");
	}

	@Override
	public void doPrint() {
		System.out.println("PrintImpl2===============doPrint()");
	}

}
