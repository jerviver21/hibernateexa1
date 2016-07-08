package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("CC")
public class CreditCardE3 extends BillingDetailsE3{
	
	@NotNull
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
