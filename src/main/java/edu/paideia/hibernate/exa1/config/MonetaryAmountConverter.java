package edu.paideia.hibernate.exa1.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import edu.paideia.hibernate.exa1.model.MonetaryAmount;

@Converter(autoApply=true)
public class MonetaryAmountConverter implements  AttributeConverter<MonetaryAmount, String>{

	@Override
	public String convertToDatabaseColumn(MonetaryAmount ma) {
		return ma.toString();
	}

	@Override
	public MonetaryAmount convertToEntityAttribute(String s) {
		return MonetaryAmount.fromString(s);
	}

}
