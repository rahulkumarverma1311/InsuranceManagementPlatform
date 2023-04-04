package com.company.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Claims {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimNumber;
	private String descriptions;
	private String date;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private InsurancePolicies insurancePolicies1;
	


}
