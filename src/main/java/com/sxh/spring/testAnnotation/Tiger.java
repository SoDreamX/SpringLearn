package com.sxh.spring.testAnnotation;

import org.springframework.stereotype.Service;

@Service
public class Tiger {
	private String tigerName = "老虎";
	@Override
	public String toString() {
		return "TigerName:"+tigerName;
	}
}
