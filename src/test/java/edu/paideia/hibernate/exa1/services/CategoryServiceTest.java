package edu.paideia.hibernate.exa1.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.Address;
import edu.paideia.hibernate.exa1.model.Category1;
import edu.paideia.hibernate.exa1.model.Category1Summary;
import edu.paideia.hibernate.exa1.model.Category2;
import edu.paideia.hibernate.exa1.model.CategoryType;
import edu.paideia.hibernate.exa1.model.Employee;
import edu.paideia.hibernate.exa1.model.MonetaryAmount;

public class CategoryServiceTest {

	//Taller1
	//@Test(expected=ConstraintViolationException.class)
	public void testValidationDate()throws Exception {
		Date date = new Date();
		Category1 c1 = new Category1();
		c1.setName("Category1");
		c1.setExpiredDate(date);
		CategoryService c1s = new CategoryService();
		c1s.saveCategory(c1);		
	}
	
	//Taller1
	//@Test(expected=ConstraintViolationException.class)
	public void testValidationNameSize()throws Exception {	
		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName("C");
		c1.setExpiredDate(date);
		CategoryService c1s = new CategoryService();
		c1s.saveCategory(c1);
	}
	
	//Taller1, Taller2
	//@Test
	public void testSaveCategory1() {
		String categoryName = "Category"+(int)(Math.random()*1000000);

		Date date = new Date(new Date().getTime()+(1*24*60*1000));
		Category1 c1 = new Category1();
		c1.setName(categoryName);
		c1.setExpiredDate(date);
		CategoryService c1s = new CategoryService();
		c1s.saveCategory(c1);
		
		Category1 c2 = c1s.getCategory1ByName(categoryName);
		
		assertEquals(c2.getName(), categoryName);
		assertEquals(c2.getExpiredDate(), date);
		
		//Category1 c3 = c1s.getCategory1ByDate(date);
		
		//assertEquals(c3.getName(), categoryName);
		//assertEquals(c3.getExpiredDate(), date);
		
		
		
	}
	
	//Taller4
	//@Test
	public void testCategorySummary() {
		CategoryService c1s = new CategoryService();
		List<Category1Summary> list = c1s.getCategory1Summary();
		assertTrue(!list.isEmpty());		
		list.stream().forEach(c -> System.out.println(c.getName()));
	}
	
	
	//Taller5, Taller6
	//@Test
	public void testSaveCategory2() {
		String categoryName = "Category"+(int)(Math.random()*1000000);
		
		CategoryType type = CategoryType.CATEGORY3;

		Category2 c = new Category2();
		c.setName(categoryName);
		c.setType(CategoryType.CATEGORY3);
		c.setMetricWeight(100);
		CategoryService cs = new CategoryService();
		cs.saveCategory(c);
		
		Category2 c2 = cs.getCategory2ByName(categoryName);
		
		assertEquals(c2.getName(), categoryName);
		assertEquals(c2.getType(), type);
		
		System.out.println(">>>>>>>>>: "+c2.getFrag()+" --- "+c2.getFirstCreate());
			
		
	}
	
	//Taller7, Taller 8
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
		
		
		
		CategoryService cs = new CategoryService();
		cs.saveEmployee(e1);
		cs.saveEmployee(e2);
		
		
		
	}
	
}
