package edu.paideia.hibernate.exa1.services;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.associations.om.CategoryOM1;
import edu.paideia.hibernate.exa1.model.associations.om.ItemOM;

public class CategoryOMTest {
	
	//Taller 18
	@Test
	public void testSaveCategoryOM() {
		CategoryOM1 category1 = new CategoryOM1("category1");
		CategoryOM1 category2 = new CategoryOM1("category2");
		
		ItemOM item1 = new ItemOM("Item1_1", 550);
		ItemOM item2 = new ItemOM("Item1_2", 650);
			
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		CategoryService cs = new CategoryService();
		cs.saveCategoryOM(category1);
		
//Lo siguiente no guardaría en la tabla intermedia, asi item tenga cascade para category
//Por tanto el mappedBy es importante, para definir la navegabilidad de persistencia.
//		item1.getCategories().add(category1);
//		item1.getCategories().add(category2);
//		
//		ItemService is = new ItemService();
//		is.save(item1);
	}

}
