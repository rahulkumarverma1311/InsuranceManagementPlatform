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

import com.company.entities.Claims;
import com.company.repository.service.ClaimsService;

@RestController
@RequestMapping("/api/claims")
public class ClaimsController {
	@Autowired
	private ClaimsService claimsService;

	@GetMapping()
	public ResponseEntity<List<Claims>> getAll() {
		List<Claims> list = this.claimsService.getAll();
		if (list.size() <= 0) {
			return new ResponseEntity<List<Claims>>(list, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Claims>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Claims> findById(@PathVariable("id") int id) {
		Claims claims = this.claimsService.getById(id);
		if (claims == null) {
			return new ResponseEntity<Claims>(claims, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Claims>(claims, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Claims>addClaims(@RequestBody Claims claims){
		try {
			Claims claims2 = this.claimsService.addClaims(claims);
			return new ResponseEntity<Claims>(claims2, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/id")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		try {
			this.claimsService.deleteClaims(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Claims>updateClaims(@PathVariable("id") int id, @RequestBody Claims claims ){
		try {
			Claims updateClaims = this.claimsService.updateClaims(id, claims);
			return new ResponseEntity<Claims>(updateClaims, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
