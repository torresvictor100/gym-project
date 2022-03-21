package com.backend.gym.project.reposity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.gym.project.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByNameContainingIgnoreCase(String name);
	
	Optional<Client> findByName(String name);
	


}
