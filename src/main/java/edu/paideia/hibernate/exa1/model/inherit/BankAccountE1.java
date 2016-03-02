package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class BankAccountE1 extends BillingDetailsE1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String accountNumber;
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String cardNumber) {
		this.accountNumber = cardNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
