package edu.paideia.hibernate.exa1.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.Category1;

public class Category1ServiceTest {

	@Test(expected=ConstraintViolationException.class)
	public void testValidationDate()throws Exception {
		Date date = new Date();
		Category1 c1 = new Category1();
		c1.setName("Category1");
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);		
	}
	
	
	@Test(expected=ConstraintViolationException.class)
	public void testValidationNameSize()throws Exception {	
		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName("C");
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);
	}
	
	
	@Test
	public void testSaveCategory() {
		String categoryName = "Category"+(int)(Math.random()*1000000);

		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName(categoryName);
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);
		
		Category1 c = c1s.getCategory1(categoryName);
		
		assertEquals(c.getName(), categoryName);
		assertEquals(c.getExpiredDate(), date);
		
		
		
	}
	
}
