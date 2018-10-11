package com.sxh.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxh.spring.bean.Student;

@Controller
@RequestMapping(value="/test")
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="show")
	public String showStudent(Student student,Model model) {
		logger.info("进入/test/show");
		model.addAttribute("student", student);
		logger.info(student.toString());
		return "test";
	}
}
