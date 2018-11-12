package com.sxh.spring.testAop;

public class PrintImpl1 implements PrintInterface {

	@Override
	public void printInfo() {
		System.out.println("PrintImpl1===============printInfo()");
	}

	@Override
	public void doPrint() {
		System.out.println("PrintImpl1===============doPrint()");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
