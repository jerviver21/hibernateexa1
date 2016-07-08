package edu.paideia.hibernate.exa1.services;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import edu.paideia.hibernate.exa1.model.Address;
import edu.paideia.hibernate.exa1.model.Employee;
import edu.paideia.hibernate.exa1.model.EmployeeIH1;
import edu.paideia.hibernate.exa1.model.EmployeeIH2;
import edu.paideia.hibernate.exa1.model.EmployeeIH3;
import edu.paideia.hibernate.exa1.model.EmployeeIH4;
import edu.paideia.hibernate.exa1.model.MonetaryAmount;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE1;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE2;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE3;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE4;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE3;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE1;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE2;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE3;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE4;

public class EmployeeServiceTest {
	Employee emc;
	EmployeeIH1 e1;
	EmployeeIH2 e2_1;
	EmployeeIH2 e2_2;
	EmployeeIH2 e2_3;
	EmployeeIH3 e3;
	EmployeeIH4 e4_1;
	EmployeeIH4 e4_2;
	EmployeeIH4 e4_3;
	
	//Mocks
	EntityManager emMock = mock(EntityManager.class);
	Query qmReturnE41 = mock(Query.class);
	Query qmReturnE41WithParameter = mock(Query.class);
	
	
	@Before
	public void init(){
		//Employee for mapping types and converters
		emc = new Employee();
		emc.setName("EMC Viveros");
		
		//Employee for inheritance strategy 1
		e1 = new EmployeeIH1();
		e1.setName("E1 Viveros");
		
		//Employees for inheritance strategy 2
		e2_1 = new EmployeeIH2();
		e2_1.setName("E2_1 Viveros");
		
		e2_2 = new EmployeeIH2();
		e2_2.setName("E2_2 Viveros");
		
		e2_3 = new EmployeeIH2();
		e2_3.setName("E2_3 Viveros");
		
		//Employee for inheritance strategy 3
		e3 = new EmployeeIH3();
		e3.setName("E3 Viveros");
		
		//Employees for inheritance strategy 4
		e4_1 = new EmployeeIH4();
		e4_1.setName("E4_1 Viveros");
		
		e4_2 = new EmployeeIH4();
		e4_2.setName("E4_2 Viveros");
		
		e4_3 = new EmployeeIH4();
		e4_3.setName("E4_3 Viveros");
		
		
		EmployeeIH4 e41m = new EmployeeIH4();
		e41m.setName(e4_1.getName());
		when(emMock.createNamedQuery("employee4ByName")).thenReturn(qmReturnE41);
		when(qmReturnE41.setParameter("name", e4_1.getName())).thenReturn(qmReturnE41WithParameter);
		when(qmReturnE41WithParameter.getSingleResult()).thenReturn(e41m);
	}

	//Taller7 y Taller8
	//@Test
	public void testTypingConverting() {
		Address a1 = new Address();
		Address a2 = new Address();
		MonetaryAmount ma = new MonetaryAmount(5849000l, Currency.getInstance("COP"));
		
		a1.setStreet("Aureliano");
		a1.setNumber(11);
		
		a2.setStreet("Siempre Viva");
		a2.setNumber(123);

		emc.setName(emc.getName());
		emc.setAddress(a1);
		emc.setAlterAddress(a2);
		emc.setSalary(ma);
		
		EmployeeService cs = new EmployeeService();
		cs.save(emc);

	}
	
	//Taller9
	//@Test
	public void testInhStrategy1(){

		CreditCardE1 creditCardE1 = new CreditCardE1();
		creditCardE1.setCardNumber("6362150001739483");
		creditCardE1.setOwner(e1.getName());
		creditCardE1.setEmployee(e1);
		
		BankAccountE1 accountE1 = new BankAccountE1();
		accountE1.setOwner(e1.getName());
		accountE1.setAccountNumber("092456312-1");
		accountE1.setEmployee(e1);
		
		List<CreditCardE1> cards = new ArrayList<>();
		cards.add(creditCardE1);
		
		List<BankAccountE1> accounts = new ArrayList<>();
		accounts.add(accountE1);
		
		e1.setAccounts(accounts);
		e1.setCreditCards(cards);

		EmployeeService cs = new EmployeeService();
		cs.save(e1);
		
		
		EmployeeIH1 e = cs.getEmployee1ByName(e1.getName());
		BankAccountE1 ba = e1.getAccounts().get(0);
		CreditCardE1 cc = e1.getCreditCards().get(0);
		System.out.println("************"+ba.getOwner()+" <-> "+ba.getAccountNumber());
		System.out.println("************"+cc.getCardNumber());

	}
	
	//Taller10
	//@Test
	public void testInhStrategy2(){

		BankAccountE2 a1 = new BankAccountE2();
		a1.setOwner(e2_1.getName());
		a1.setAccountNumber("092456312-1");
		
		CreditCardE2 cc1 = new CreditCardE2();
		cc1.setCardNumber("6362150001739999");
		cc1.setOwner(e2_2.getName());
		
		CreditCardE2 cc2 = new CreditCardE2();
		cc2.setCardNumber("6362150001739999");
		cc2.setOwner(e2_3.getName());
		
		e2_1.setBillingDetail(a1);
		e2_2.setBillingDetail(cc1);
		e2_3.setBillingDetail(cc2);
		
		EmployeeService cs = new EmployeeService();
		cs.save(e2_1);
		cs.save(e2_2);
		cs.save(e2_3);
		
		EmployeeIH2 e = cs.getEmployee2ByName(e2_1.getName());
		BankAccountE2 ba1 = (BankAccountE2)e.getBillingDetail();
		System.out.println("************"+ba1.getOwner()+" <-> "+ba1.getAccountNumber());
		EmployeeIH2 e1 = cs.getEmployee2ByName(e2_2.getName());
		System.out.println("************"+((CreditCardE2)e1.getBillingDetail()).getCardNumber());

	}

	//Taller11
	//@Test
	public void testInhStrategy3() {
		BankAccountE3 account = new BankAccountE3();
		account.setOwner(e3.getName());
		account.setAccountNumber("092456312-1");
		account.setEmployee(e3);
		
		CreditCardE3 card1 = new CreditCardE3();
		card1.setCardNumber("6362150001739999");
		card1.setOwner(e3.getName());
		card1.setEmployee(e3);
		
		
		CreditCardE3 card2 = new CreditCardE3();
		card2.setCardNumber("6362150001739483");
		card2.setOwner(e3.getName());
		card2.setEmployee(e3);
		
		
		List<BillingDetailsE3> bd3 = new ArrayList<>();
		bd3.add(card2);
		bd3.add(card1);
		bd3.add(account);
		
		e3.setBillingDetails(bd3);

		EmployeeService cs = new EmployeeService();
		cs.save(e3);
		
		EmployeeIH3 e = cs.getEmployee3ByName(e3.getName());
		System.out.println("************"+e.getBillingDetails().get(0).getOwner()+" <-> "+e.getName());	
	}
	
	//Taller12
	//@Test
	public void testInhStrategy4(){

		BankAccountE4 a1 = new BankAccountE4();
		a1.setOwner(e2_1.getName());
		a1.setAccountNumber("092456312-1");
		
		CreditCardE4 cc1 = new CreditCardE4();
		cc1.setCardNumber("6362150001739999");
		cc1.setOwner(e2_2.getName());
		
		CreditCardE4 cc2 = new CreditCardE4();
		cc2.setCardNumber("6362150001739999");
		cc2.setOwner(e2_3.getName());
		
		e4_1.setBillingDetail(a1);
		e4_2.setBillingDetail(cc1);
		e4_3.setBillingDetail(cc2);
		
		EmployeeService cs = new EmployeeService();
		cs.save(e4_1);
		cs.save(e4_2);
		cs.save(e4_3);
		
		EmployeeIH4 e = cs.getEmployee4ByName(e4_1.getName());
		BankAccountE4 ba1 = (BankAccountE4)e.getBillingDetail();
		System.out.println("************"+ba1.getOwner()+" <-> "+ba1.getAccountNumber());
		EmployeeIH4 e1 = cs.getEmployee4ByName(e4_2.getName());
		System.out.println("************"+((CreditCardE4)e1.getBillingDetail()).getCardNumber());
	}
	
	
	//Taller 13
	@Test
	public void testGetEmployee4ByName(){
		EmployeeService cs = new EmployeeService();
		cs.setEm(emMock);
		EmployeeIH4 e = cs.getEmployee4ByName(e4_1.getName());
		assertEquals(e.getName(), e4_1.getName());
		System.out.println("****************"+e.getName());
	}
	


}
