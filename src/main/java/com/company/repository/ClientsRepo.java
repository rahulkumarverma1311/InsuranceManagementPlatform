package com.company.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Clients;

public interface ClientsRepo extends JpaRepository<Clients, Integer> {
	
	 public Clients findById(int id);

}
