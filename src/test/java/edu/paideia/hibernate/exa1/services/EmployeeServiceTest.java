package edu.paideia.hibernate.exa1.services;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.Address;
import edu.paideia.hibernate.exa1.model.Employee;
import edu.paideia.hibernate.exa1.model.MonetaryAmount;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE2;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE2;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE1;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE2;

public class EmployeeServiceTest {

	
	//Taller 7, Taller 8, Taller 9 
	@Test
	public void testSaveEmployee() {
		Employee e1 = new Employee();
		Address a1 = new Address();
		Address a2 = new Address();
		MonetaryAmount ma = new MonetaryAmount(5849000l, Currency.getInstance("COP"));
		
		a1.setStreet("Aureliano");
		a1.setNumber(11);
		
		a2.setStreet("Siempre Viva");
		a2.setNumber(123);

		e1.setName("Jerson Viveros");
		e1.setAddress(a1);
		e1.setAlterAddress(a2);
		e1.setSalary(ma);
		
		
		
		
		Employee e2 = new Employee();
		e2.setName("Michael Viveros");
		e2.setSalary(new MonetaryAmount(3000000l, Currency.getInstance("COP") ));
		
		
		BankAccountE2 account = new BankAccountE2();
		account.setOwner("Jerson Viveros");
		account.setAccountNumber("092456312-1");
		account.setEmployee(e1);
		
		CreditCardE2 creditCard1 = new CreditCardE2();
		creditCard1.setCardNumber("6362150001739999");
		creditCard1.setOwner("Jerson Viveros");
		creditCard1.setEmployee(e2);
		
		
		CreditCardE1 creditCard = new CreditCardE1();
		creditCard.setCardNumber("6362150001739483");
		creditCard.setOwner("Jerson Viveros");
		creditCard.setEmployee(e1);
		
		
		List<CreditCardE1> cards = new ArrayList<>();
		cards.add(creditCard);
		
		List<BillingDetailsE2> accountsE1 = new ArrayList<>();
		List<BillingDetailsE2> accountsE2 = new ArrayList<>();
		accountsE1.add(account);
		accountsE2.add(creditCard1);
		
		e1.setAccount(accountsE1);
		e1.setCreditCard(cards);
		
		e2.setAccount(accountsE2);
		
		EmployeeService cs = new EmployeeService();
		cs.save(e1);
		cs.save(e2);
		
			
		
	}

}
