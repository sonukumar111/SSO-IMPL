package com.onpassive.sso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.onpassive.sso.dto.UserRegistrationDto;
import com.onpassive.sso.model.UserDetails;
import com.onpassive.sso.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails save(UserRegistrationDto registrationDto) {
		UserDetails user = new UserDetails(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getRole());
		
		return userRepository.save(user);
	}
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("Loading user details by mail id ");
		UserDetails user = userRepository.findByEmail(username);
		if(user == null) {
			logger.info("User not found with the given id : "+username);
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		logger.info("User Found : ");
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(Arrays.asList((user.getRole()))));		
	}
	
	private ArrayList<SimpleGrantedAuthority> mapRolesToAuthorities(List<String> roles){
			SimpleGrantedAuthority sga=new SimpleGrantedAuthority(roles.get(0));
			ArrayList<SimpleGrantedAuthority> al=new ArrayList<SimpleGrantedAuthority>();
			al.add(sga);
			logger.info("USER ROLE IS : "+roles.get(0));
			return al;
	}	
}
