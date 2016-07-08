package edu.paideia.hibernate.exa1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE4;

@Entity
@NamedQueries({
	@NamedQuery(
			name="employee4ByName", 
			query="SELECT c FROM EmployeeIH4 c WHERE c.name = :name"
	)
})

public class EmployeeIH4 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private BillingDetailsE4 billingDetail;

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

	public BillingDetailsE4 getBillingDetail() {
		return billingDetail;
	}

	public void setBillingDetail(BillingDetailsE4 billingDetail) {
		this.billingDetail = billingDetail;
	}


}