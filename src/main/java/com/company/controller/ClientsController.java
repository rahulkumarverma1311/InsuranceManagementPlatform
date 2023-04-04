package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entities.Clients;
import com.company.repository.service.ClientsService;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {
	
	@Autowired
	private ClientsService clientsService;
	
	@GetMapping()
	public ResponseEntity<List<Clients>>getAll(){
		List<Clients> list = this.clientsService.getAll();
		if(list.size()<=0) {
			return new ResponseEntity<List<Clients>>(list, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Clients>>(list, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Clients>getById(@PathVariable("id") int id){
		Clients clients = this.clientsService.findById(id);
		if(clients == null) {
			return new ResponseEntity<Clients>(clients, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Clients>(clients, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Clients>addClients(@RequestBody Clients clients){
		try {
			Clients Clients2 = this.clientsService.addClients(clients);
			return new ResponseEntity<Clients>(Clients2, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Clients>(clients, HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable("id") int id){
		try {
			this.clientsService.deletCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Clients>update(@PathVariable("id") int id , @RequestBody Clients clients){
		try {
			Clients updateClient= this.clientsService.update(id, clients);
			return new ResponseEntity<Clients>(updateClient, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Clients>(HttpStatus.BAD_REQUEST);
		}
	}


}
