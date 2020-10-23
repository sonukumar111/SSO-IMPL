package com.onpassive.sso.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.onpassive.sso.dto.UserRegistrationDto;
import com.onpassive.sso.model.UserDetails;


public interface UserService extends UserDetailsService{
	UserDetails save(UserRegistrationDto registrationDto);
}
