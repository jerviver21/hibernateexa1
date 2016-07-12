package edu.paideia.hibernate.exa1.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.paideia.hibernate.exa1.model.associations.Item;

public class ItemServiceTest {
	
	@Test
	public void testSaveItemSet(){
		System.out.println("running items set");
		Item item1 = new Item("item1");
		Set<String> images = item1.getImagesSet();
		images.add("img1.jpg");
		images.add("img2.jpg");
		images.add("img3.jpg");
		
		ItemService is = new ItemService();
		is.save(item1);
	}
	
	@Test
	public void testSaveItemBag(){
		System.out.println("running items bag");
		Item item1 = new Item("item2");
		Collection<String> images = item1.getImagesBag();
		images.add("img1.jpg");
		images.add("img2.jpg");
		images.add("img3.jpg");
		
		ItemService is = new ItemService();
		is.save(item1);
		
	}
	
	@Test
	public void testSaveItemList(){
		Item item2 = new Item("item3");
		List<String> images = item2.getImagesList();
		images.add("img1.jpg");
		images.add("img2.jpg");
		images.add("img3.jpg");

		
		ItemService is = new ItemService();
		is.save(item2);
		
	}
	
	@Test
	public void testSaveItemMap(){
		Item item2 = new Item("item2");
		Map<String, String> images = item2.getImagesMap();
		images.put("img1", "img1.jpg");
		images.put("img2", "img2.jpg");
		images.put("img3", "img3.jpg");
		
		ItemService is = new ItemService();
		is.save(item2);
		
	}

}
