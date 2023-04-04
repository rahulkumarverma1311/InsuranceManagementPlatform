package com.company.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.InsurancePolicies;
import com.company.repository.InsurancePoliciesRepo;

@Service
public class InsurancePoliciesService {
	@Autowired
	private InsurancePoliciesRepo insurancePoliciesRepo;
	
	
	public List<InsurancePolicies> getAll(){
		List<InsurancePolicies> findAll = this.insurancePoliciesRepo.findAll();
		return findAll;
	}
	
	public InsurancePolicies findById(int id) {
		InsurancePolicies findById = this.insurancePoliciesRepo.findById(id);
		return findById;
	}
	
	
	public InsurancePolicies addInsurancePolicies(InsurancePolicies insurancePolicies) {
		InsurancePolicies save = this.insurancePoliciesRepo.save(insurancePolicies);
		return save;
	}
	
	public void deleteInsurancePolicies(int id) {
		this.insurancePoliciesRepo.deleteById(id);
	}
	
	public InsurancePolicies update(int id , InsurancePolicies insurancePolicies) {
		insurancePolicies.setPolicyNumber(id);
		InsurancePolicies save = this.insurancePoliciesRepo.save(insurancePolicies);
		return save;
		
	}

}
