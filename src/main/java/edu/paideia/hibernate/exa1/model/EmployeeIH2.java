package edu.paideia.hibernate.exa1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE2;

//Taller7
@Entity
@NamedQueries({
	@NamedQuery(
			name="employee2ByName", 
			query="SELECT c FROM EmployeeIH2 c WHERE c.name = :name"
	)
})

public class EmployeeIH2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private BillingDetailsE2 billingDetail;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BillingDetailsE2 getBillingDetail() {
		return billingDetail;
	}

	public void setBillingDetail(BillingDetailsE2 billingDetail) {
		this.billingDetail = billingDetail;
	}


}