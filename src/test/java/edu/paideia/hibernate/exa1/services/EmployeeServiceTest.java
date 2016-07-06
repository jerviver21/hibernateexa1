package edu.paideia.hibernate.exa1.services;

import static org.junit.Assert.assertEquals;

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
		
		
		BankAccountE2 accountE2 = new BankAccountE2();
		accountE2.setOwner("Jerson Viveros");
		accountE2.setAccountNumber("092456312-1");
		accountE2.setEmployee(e1);
		
		CreditCardE2 creditCardE2 = new CreditCardE2();
		creditCardE2.setCardNumber("6362150001739999");
		creditCardE2.setOwner("Jerson Viveros");
		creditCardE2.setEmployee(e2);
		
		
		CreditCardE1 creditCardE1 = new CreditCardE1();
		creditCardE1.setCardNumber("6362150001739483");
		creditCardE1.setOwner("Jerson Viveros");
		creditCardE1.setEmployee(e1);
		
		
		List<CreditCardE1> cardsE1 = new ArrayList<>();
		cardsE1.add(creditCardE1);
		
		List<BillingDetailsE2> bankAccountsE2 = new ArrayList<>();
		List<BillingDetailsE2> creditCardsE2 = new ArrayList<>();
		bankAccountsE2.add(accountE2);
		creditCardsE2.add(creditCardE2);
		
		e1.setAccount(bankAccountsE2);
		e1.setCreditCard(cardsE1);
		
		e2.setAccount(creditCardsE2);
		
		EmployeeService cs = new EmployeeService();
		cs.save(e1);
		cs.save(e2);
		
		
		Employee e = cs.getEmployeeByName(e1.getName());
		BankAccountE2 ba2 = (BankAccountE2)e.getAccount().get(0);
		System.out.println("************"+ba2.getOwner()+" <-> "+ba2.getAccountNumber());
		System.out.println("************"+e.getCreditCard().get(0).getOwner());
		
		assertEquals(e1.getAccount().size(), e.getAccount().size());
		assertEquals(e1.getCreditCard().size(), e.getCreditCard().size());
		assertEquals(ba2.getAccountNumber(), accountE2.getAccountNumber());
	}

}
