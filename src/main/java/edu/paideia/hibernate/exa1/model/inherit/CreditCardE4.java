package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;


@Entity
@PrimaryKeyJoinColumn(name="CREDITCARD_ID")
public class CreditCardE4 extends BillingDetailsE4{
	
	@NotNull
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
