package edu.paideia.hibernate.exa1.model;

import java.io.Serializable;
import java.util.Currency;


//Taller8
public class MonetaryAmount implements Serializable{
	
	private final Long value;
	private final Currency currency;
	
	
	public MonetaryAmount(Long value, Currency currency){
		this.value = value;
		this.currency = currency;
	}

	public Long getValue() {
		return value;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	@Override
	public String toString(){
		return currency.toString()+" "+value;
	}
	
	public static MonetaryAmount fromString(String ma){
		Long value = Long.parseLong(ma.split(" ")[0]);
		Currency currency = Currency.getInstance(ma.split(" ")[1]);
		return new MonetaryAmount(value, currency);
	}
	

	

}
