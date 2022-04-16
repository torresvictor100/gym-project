package com.backend.gym.project.reposity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.gym.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
		
		Optional<User> findByUserName(String UserName);
		


}
