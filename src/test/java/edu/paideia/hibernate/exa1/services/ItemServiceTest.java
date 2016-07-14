package edu.paideia.hibernate.exa1.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import edu.paideia.hibernate.exa1.model.associations.Bid;
import edu.paideia.hibernate.exa1.model.associations.Image;
import edu.paideia.hibernate.exa1.model.associations.Item;
import edu.paideia.hibernate.exa1.model.associations.Item1;

public class ItemServiceTest {
	
	//@Test
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
	
	//@Test
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
	
	//@Test
	public void testSaveItemList(){
		Item item2 = new Item("item3");
		List<String> images = item2.getImagesList();
		images.add("img1.jpg");
		images.add("img2.jpg");
		images.add("img3.jpg");

		
		ItemService is = new ItemService();
		is.save(item2);
		
	}
	
	//@Test
	public void testSaveItemMap(){
		Item item2 = new Item("item2");
		Map<String, String> images = item2.getImagesMap();
		images.put("img1", "img1.jpg");
		images.put("img2", "img2.jpg");
		images.put("img3", "img3.jpg");
		
		ItemService is = new ItemService();
		is.save(item2);
		
	}
	
	//@Test
	public void testSaveItemEmbeed(){
		Item item2 = new Item("itemEmbeed");
		List<Image> images = item2.getImagesEmbeed();
		images.add(new Image("ie1","ie1.jpg",10,20));
		images.add(new Image("ie2","ie2.jpg",10,20));
		images.add(new Image("ie3","ie3.jpg",10,20));
		
		ItemService is = new ItemService();
		is.save(item2);
	}
	
	//Taller 14
	@Test
	public void testSaveItem1(){
		Item1 item2 = new Item1("Item test OneToMany");
		item2.getBids().add(new Bid("bid1", item2));
		item2.getBids().add(new Bid("bid2", item2));
		item2.getBids().add(new Bid("bid3", item2));
		
		ItemService is = new ItemService();
		is.save(item2);		
	}

}
