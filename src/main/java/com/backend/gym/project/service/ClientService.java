package com.backend.gym.project.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	
	public Client save(Client client)  {
				
		client.setId(null);
		Date data = new Date();
		GregorianCalendar dataCal = new GregorianCalendar();
		dataCal.setTime(data);
		int month = dataCal.get((Calendar.MONTH));
		int year = dataCal.get(Calendar.YEAR);
		if(month == 12) {
			client.setLastMouthPaid(0);
			client.setpaidYear(year+1);
		}else {
			client.setLastMouthPaid(month + 1);
			client.setpaidYear(year);
		}
		
		
		
		
		return clientRepository.save(client);
	}
	
	
	public String monthlyFee(Long id) {
		
		Date data = new Date();
		GregorianCalendar dataCal = new GregorianCalendar();
		dataCal.setTime(data);
		int currentDay = dataCal.get((Calendar.DAY_OF_MONTH));
		int currentMonth = dataCal.get((Calendar.MONTH));
		int currentYear = dataCal.get(Calendar.YEAR);
		
		
		Client client = clientRepository.findById(id).orElse(null);
		String status ="";
		
		if (id != null && clientRepository.existsById(id)) {
			
			if(currentYear < client.getpaidYear()) {
				
				status = "estar pago";
				
			}else if(currentMonth < client.getLastMouthPaid() && currentYear <= client.getpaidYear()) {
				
				status = "estar pago";
				
			}else if (currentDay <= client.getDatePagament() 
					&& currentMonth <= client.getLastMouthPaid() 
					&& currentYear <= client.getpaidYear()) {
				
				status = "estar pago";
				
			}else {
				
				status = "não pagou esse mês";
			}
			
			
			return status;
		} else {
			return "usuario não emcontrado";
		}
	}
	
	public Client paymentMonth(Long id) {
		
		Client client = clientRepository.findById(id).orElse(null);
		
		if (id != null && clientRepository.existsById(id)) {
			
			if(client.getLastMouthPaid() == 11) {
				client.setLastMouthPaid(0);
				client.setpaidYear(client.getpaidYear() +1);
			}else {
				client.setLastMouthPaid(client.getLastMouthPaid()+1);
			}				
			return clientRepository.save(client);
		} else {
			return null;
		}
		
	}
	
	public Client subscriptionReactivation(Client client) {
		Long id = client.getId();
		
		if (id != null && clientRepository.existsById(id)) {
			
			Date data = new Date();
			GregorianCalendar dataCal = new GregorianCalendar();
			dataCal.setTime(data);
			int month = dataCal.get((Calendar.MONTH));
			int year = dataCal.get(Calendar.YEAR);
			
			client.setLastMouthPaid(month);
			client.setpaidYear(year);
			
			return clientRepository.save(client);
		} else {
			
			return null;	
		}
	}
	
	
	
	public Client update(Client client) {
		Long id = client.getId();
		if (id != null && clientRepository.existsById(id)) {
			
			Client clientBeforeUpdate = clientRepository.findById(id).orElse(null); 
			
			int month = clientBeforeUpdate.getLastMouthPaid();
			int year = clientBeforeUpdate.getpaidYear();
			
			client.setLastMouthPaid(month);
			client.setpaidYear(year);
			
			return clientRepository.save(client);
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
