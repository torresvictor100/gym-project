package com.backend.gym.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.gym.project.entity.User;
import com.backend.gym.project.reposity.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User findByUserName(String UserName) {
		return userRepository.findByUserName(UserName).orElse(null);
	}
	
	public User save(User user)  {
		user.setId(null);
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
	}
	
	
	public void deleteAll() {
		userRepository.deleteAllInBatch();
	}

}