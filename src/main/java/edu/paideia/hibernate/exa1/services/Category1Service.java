package edu.paideia.hibernate.exa1.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.Category1;
import edu.paideia.hibernate.exa1.model.Category1Summary;

public class Category1Service {
	
	private final String PU = "HelloWorldPU";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public Category1Service(){
		em = emf.createEntityManager();
	}
	
	public void saveCategory(Category1 category){
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

}
