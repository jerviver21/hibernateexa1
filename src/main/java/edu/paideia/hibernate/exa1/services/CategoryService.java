package edu.paideia.hibernate.exa1.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.Category1;
import edu.paideia.hibernate.exa1.model.Category1Summary;
import edu.paideia.hibernate.exa1.model.Category2;
import edu.paideia.hibernate.exa1.model.associations.om.CategoryOM1;

public class CategoryService {
	
	private final String PU = "HelloWorldPU";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public CategoryService(){
		em = emf.createEntityManager();
	}
	
	public void saveCategory(Category1 category){
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}
	
	public void saveCategoryOM(CategoryOM1 category){
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}
	
	
	public Category1 getCategory1ByName(String name){
		@SuppressWarnings("unchecked")
		List<Category1> categories = em.createNamedQuery("categoryByName")
									 .setParameter("name", name).getResultList();
		if(!categories.isEmpty()){
			return categories.get(0);
		}
		return null;
	}
	
	public Category1 getCategory1ByDate(Date date){
		@SuppressWarnings("unchecked")
		List<Category1> categories = em.createNamedQuery("categoryByDate")
									 .setParameter("date", date).getResultList();
		if(!categories.isEmpty()){
			return categories.get(0);
		}
		return null;
	}
	
	public List<Category1Summary> getCategory1Summary(){
		@SuppressWarnings("unchecked")
		List<Category1Summary> categories = em.createQuery("SELECT c FROM Category1Summary c")
			.getResultList();
		return categories;
	}

	public void saveCategory(Category2 c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	}
	

	public Category2 getCategory2ByName(String name) {
		@SuppressWarnings("unchecked")
		List<Category2> categories = em.createNamedQuery("category2ByName")
									 .setParameter("name", name).getResultList();
		if(!categories.isEmpty()){
			return categories.get(0);
		}
		return null;
	}

}
