package com.google.project.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		// TODO Auto-generated constructor stub
		return "Hello";
	}

	@RequestMapping("/index")
	public String index() {
		// TODO Auto-generated constructor stub
		return "index";
	}
}
