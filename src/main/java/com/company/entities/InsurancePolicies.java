package com.company.entities;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class InsurancePolicies {
	@Id
	private int id;
	private int policyNumber;
	private String policyType;
	private Integer coverageAmount;
	private Boolean premium;
	private String startDate;
	private String endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	private Clients clients;

}
