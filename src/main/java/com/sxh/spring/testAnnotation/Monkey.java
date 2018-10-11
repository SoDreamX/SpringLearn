package com.sxh.spring.testAnnotation;

import org.springframework.stereotype.Service;

@Service("monkey")
public class Monkey {
	private String monkeyName = "猴子";
	@Override
	public String toString() {
		return "MonkeyName:"+monkeyName;
	}
}
