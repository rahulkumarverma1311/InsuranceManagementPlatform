package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.InsurancePolicies;

public interface InsurancePoliciesRepo extends JpaRepository<InsurancePolicies, Integer> {
	
	public InsurancePolicies findById(int id);

}
