package edu.paideia.hibernate.exa1.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class Address {
	
	@NotNull
	private String street;
	
	@NotNull
	private Integer number;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
