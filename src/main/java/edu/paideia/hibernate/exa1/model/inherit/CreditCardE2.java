package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class CreditCardE2 extends BillingDetailsE2{
	
	@NotNull
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
