package com.backend.gym.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public void save() throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM"); 
		Date dataFormatada = formato.parse("11/12");
		
		Client client = new Client();

		client.setId(null);
		client.setName("test");
		client.setNumero("8762-9587");
		client.setPaymentDate(dataFormatada);
		
		
		client = clientService.save(client);
		System.out.println(client);
	}
	
	@Test
	public void findByName() {

		String name = "test";
		Client client = clientService.findByName(name);
		System.out.println(client);
	}
	
	@Test
	public void update() throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = formato.parse("11/12/2020");
		
		Client client = new Client();
		client.setId(1L);
		client.setName("test");
		client.setNumero("8762-9587");
		client.setPaymentDate(dataFormatada);
		
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
