package com.backend.gym.project.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.backend.gym.project.entity.Client;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ClientServiceTest {
	
	@Autowired
	ClientService clientService;

	
	@Test
	public void findAll() {

		List<Client> client = clientService.findAll();
		client.forEach(System.out::println);
	}
	
	
	@Test
	public void findById() {

		Long id = 1L;
		Client client = clientService.findById(id);
		System.out.println(client);
	}
	
	@Test
	public void save()  {
		
					
			Client client = new Client();

			client.setId(null);
			client.setName("test");
			client.setNumero("8762-9587");
			client.setDatePagament(10);
			
			client = clientService.save(client);
			
			System.out.println(client);
		
	}
	
	@Test
	public void monthlyFee() {
		
		
		
		System.out.println(clientService.monthlyFee(7L));
		System.out.println(clientService.findById(7L));
	}
	
	@Test
	public void findByName() {

		String name = "test";
		Client client = clientService.findByName(name);
		System.out.println(client);
	}
	
	@Test
	public void paymentMonth() {
		clientService.paymentMonth(7L);
		Client client = clientService.findById(7L);
		System.out.println(client);
	}
	
	
	@Test
	public void subscriptionReactivation() {
		Client client = new Client();
		client.setId(10L);
		client.setName("test");
		client.setNumero("8762-9587");
		client.setDatePagament(20);
		client.setLastMouthPaid(10);
		
		client = clientService.subscriptionReactivation(client.getId());
		System.out.println(client);
	}
	
	@Test
	public void update(){
		
		
		Client client = new Client();
		client.setId(10L);
		client.setName("test");
		client.setNumero("8762-9587");
		client.setDatePagament(20);
		client.setLastMouthPaid(10);
		
		client = clientService.update(client);
		System.out.println(client);
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		clientService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		clientService.deleteAll();
	}
	
	
}
