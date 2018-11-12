package com.sxh.spring.testAop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CutPointTime {
	public void beforeMethod() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curtime = sdf.format(date);
		System.out.println("方法开始时间："+curtime);
	}
	public void afterMethod() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curtime = sdf.format(date);
		System.out.println("方法结束时间："+curtime);
	}
}
