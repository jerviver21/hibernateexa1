package edu.paideia.hibernate.exa1.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.config.MonetaryAmountConverter;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE1;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE2;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE3;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE1;

//Taller7
@Entity
@NamedQueries({
	@NamedQuery(
			name="employee3ByName", 
			query="SELECT c FROM EmployeeIH3 c WHERE c.name = :name"
	)
})

public class EmployeeIH3 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;

	//Taller9: Single table.
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<BillingDetailsE3> billingDetails;

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

	public List<BillingDetailsE3> getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(List<BillingDetailsE3> inh3) {
		this.billingDetails = inh3;
	}
	

}