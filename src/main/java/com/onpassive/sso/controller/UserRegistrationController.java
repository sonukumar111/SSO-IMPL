package com.onpassive.sso.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onpassive.sso.dto.UserRegistrationDto;
import com.onpassive.sso.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private Logger logger=org.slf4j.LoggerFactory.getLogger(UserRegistrationController.class);
			
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		logger.info(registrationDto.toString());
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
