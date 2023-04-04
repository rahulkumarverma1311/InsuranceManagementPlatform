package com.company.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Claims;
import com.company.repository.ClaimsRepo;

@Service
public class ClaimsService {
	@Autowired
	private ClaimsRepo claimsRepo;
	
	
	public List<Claims> getAll(){
		List<Claims> list = this.claimsRepo.findAll();
		return list;		
	}
	
	public Claims getById(int id) {
		Claims claims = this.claimsRepo.findById(id);
		return claims;
	}
	
	
	public Claims addClaims(Claims claims) {
		Claims claims2 = this.claimsRepo.save(claims);
		return claims2;
	}
	
	public void deleteClaims(int id) {
		this.claimsRepo.deleteById(id);
	}
	
	public Claims updateClaims(int id , Claims claims) {
		claims.setClaimNumber(id);
		Claims claims2 = this.claimsRepo.save(claims);
		return claims2;
	}

}
