package edu.paideia.hibernate.exa1.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.config.MonetaryAmountConverter;

//Taller7
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	private Address address;
	
	@AttributeOverrides({
			@AttributeOverride(name="street", column=@Column(name="ALTER_STREET")),
			@AttributeOverride(name="number", column=@Column(name="ALTER_NUMBER"))
	})
	private Address alterAddress;
	
	
	//Taller8
	@NotNull
	@Convert(
			converter = MonetaryAmountConverter.class,
			disableConversion = false
	)
	@Column(name="SALARY", length=100)
	private MonetaryAmount salary;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAlterAddress() {
		return alterAddress;
	}

	public void setAlterAddress(Address alterAddress) {
		this.alterAddress = alterAddress;
	}

	public MonetaryAmount getSalary() {
		return salary;
	}

	public void setSalary(MonetaryAmount salary) {
		this.salary = salary;
	}
	

}
