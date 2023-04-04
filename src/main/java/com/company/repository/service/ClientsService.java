package com.company.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Clients;
import com.company.repository.ClientsRepo;

@Service
public class ClientsService {
	@Autowired
	private ClientsRepo clientsRepo;
	
	public List<Clients>getAll() {
		List<Clients> findAll = this.clientsRepo.findAll();
		return findAll;
	}
	
	public Clients findById(int id) {
		Clients findById = this.clientsRepo.findById(id);
		return findById;
	}
	
	
	public Clients addClients(Clients clients) {
		Clients save = this.clientsRepo.save(clients);
		return save;
	}
	
	
	public void deletCliente(int id) {
		this.clientsRepo.deleteById(id);
	}
	
	
	public Clients update(int id, Clients clients) {
		clients.setId(id);
		Clients save = this.clientsRepo.save(clients);
		return save;
	}

}
