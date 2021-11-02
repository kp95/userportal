package com.userportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.userportal.domain.User;
import com.userportal.repository.UserRepository;

public class UserServiceImpl {
	
	private UserRepository repo;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User register(User user) {
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		return repo.save(user);
	}
	
	public User findByEmail(String email) {
		
		return repo.findUserByEmail(email);
	}
	
	
	public User findByUsername(String username) {
		return repo.findUserByUsername(username);
	}
	public List<User> findAllUser(){
		return repo.findAll();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
