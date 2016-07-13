package edu.paideia.hibernate.exa1.services;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.associations.Address1;
import edu.paideia.hibernate.exa1.model.associations.User;

public class UserServiceTest {
	
	@Test
	public void testSaveUser(){
		System.out.println("running users test");
		Address1 add = new Address1();
		add.setCity("Cali");
		add.setStreet("Cra 64 A No 13B-256");
		add.setZipcode("76001");
		
		User usr = new User();
		usr.setName("jerviver21");
		usr.setShippingAddress(add);
		
		UserService is = new UserService();
		is.save(usr);
	}
	

}
