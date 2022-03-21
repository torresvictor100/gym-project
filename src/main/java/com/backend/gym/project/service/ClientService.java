package com.backend.gym.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.gym.project.entity.Client;
import com.backend.gym.project.reposity.ClientRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client findByName(String name) {
		return clientRepository.findByName(name).orElse(null);
	}
	
	public Client save(Client client) {
		client.setId(null);
		return clientRepository.save(client);
	}
	
	public Client update(Client client) {
		Long id = client.getId();
		if (id != null && clientRepository.existsById(id)) {
			return client;
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if (clientRepository.existsById(id)) {
			clientRepository.deleteById(id);
		}
	}
	
	
	public void deleteAll() {
		clientRepository.deleteAllInBatch();
	}

}
