package com.onpassive.sso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onpassive.sso.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{
	UserDetails findByEmail(String email);
}