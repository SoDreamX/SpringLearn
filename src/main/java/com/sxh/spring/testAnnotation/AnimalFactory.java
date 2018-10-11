package com.sxh.spring.testAnnotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalFactory {
	@Autowired
	private Tiger tiger;
	@Resource
	private Monkey monkey;
	
	@Override
	public String toString() {
		return "动物园有："+tiger.toString()+"和"+monkey.toString();
	}
}
