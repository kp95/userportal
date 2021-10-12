package com.userportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userportal.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
