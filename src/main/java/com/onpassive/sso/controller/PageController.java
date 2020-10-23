package com.onpassive.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	private Logger logger=LoggerFactory.getLogger(PageController.class);
	@GetMapping("/login")
	public String login() {
		logger.info("GETTING LOGIN PAGE");
		return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		logger.info("GETTING ADMING PAGE");
		return "admin";
	}
	@GetMapping("/user")
	public String user() {
		logger.info("GETTING USER PAGE..");
		return "user";
	}
	@GetMapping("/")
	public String home() {
		logger.info("GETTING HOME PAGE..");
		return "home";
	}
	@GetMapping("/accessDenied")
	public String accessDenied() {
		logger.info("GETTING Access Denied..");
		return "accessDenied";
	}
}
