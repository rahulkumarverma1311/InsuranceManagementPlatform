package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Claims;

public interface ClaimsRepo  extends JpaRepository<Claims, Integer>{
	
	public Claims findById(int id);

}
