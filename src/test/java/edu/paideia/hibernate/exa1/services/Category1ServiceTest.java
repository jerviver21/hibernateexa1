package edu.paideia.hibernate.exa1.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.Category1;
import edu.paideia.hibernate.exa1.model.Category1Summary;

public class Category1ServiceTest {

	//Taller1
	@Test(expected=ConstraintViolationException.class)
	public void testValidationDate()throws Exception {
		Date date = new Date();
		Category1 c1 = new Category1();
		c1.setName("Category1");
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);		
	}
	
	//Taller1
	@Test(expected=ConstraintViolationException.class)
	public void testValidationNameSize()throws Exception {	
		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName("C");
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);
	}
	
	//Taller1, Taller2
	@Test
	public void testSaveCategory() {
		String categoryName = "Category"+(int)(Math.random()*1000000);

		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName(categoryName);
		c1.setExpiredDate(date);
		Category1Service c1s = new Category1Service();
		c1s.saveCategory(c1);
		
		Category1 c2 = c1s.getCategory1ByName(categoryName);
		
		assertEquals(c2.getName(), categoryName);
		assertEquals(c2.getExpiredDate(), date);
		
		//Category1 c3 = c1s.getCategory1ByDate(date);
		
		//assertEquals(c3.getName(), categoryName);
		//assertEquals(c3.getExpiredDate(), date);
		
		
		
	}
	
	//Taller4
	@Test
	public void testCategorySummary() {
		Category1Service c1s = new Category1Service();
		List<Category1Summary> list = c1s.getCategory1Summary();
		assertTrue(!list.isEmpty());		
		list.stream().forEach(c -> System.out.println(c.getName()));
	}
	
}
