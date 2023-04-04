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

import com.company.entities.InsurancePolicies;
import com.company.repository.service.InsurancePoliciesService;

@RestController
@RequestMapping("/api/policies")
public class InsurancePoliciesController {
	
	@Autowired
	private InsurancePoliciesService insurancePoliciesService;
	
	@GetMapping()
	public ResponseEntity<List<InsurancePolicies>> getAll(){
		List<InsurancePolicies> all = this.insurancePoliciesService.getAll();
		if(all.size() <=0) {
			return new ResponseEntity<List<InsurancePolicies>>(all,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<InsurancePolicies>>(all,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InsurancePolicies>getByID(@PathVariable("id") int id){
		InsurancePolicies policies = this.insurancePoliciesService.findById(id);
		if(policies==null) {
			return new ResponseEntity<InsurancePolicies>(policies,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<InsurancePolicies>(policies,HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<InsurancePolicies>addInsurancePolicies(@RequestBody InsurancePolicies insurancePolicies){
		try {
			InsurancePolicies policies = this.insurancePoliciesService.addInsurancePolicies(insurancePolicies);
			return new ResponseEntity<InsurancePolicies>(policies,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<InsurancePolicies>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable("id") int id){
		try {
			this.insurancePoliciesService.deleteInsurancePolicies(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InsurancePolicies>update(@PathVariable("id") int id, @RequestBody InsurancePolicies insurancePolicies){
		
		try {
			InsurancePolicies policies = this.insurancePoliciesService.update(id, insurancePolicies);
			return new ResponseEntity<InsurancePolicies>(policies,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<InsurancePolicies>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
