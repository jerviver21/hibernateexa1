package edu.paideia.hibernate.exa1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.associations.Item;
import edu.paideia.hibernate.exa1.model.associations.Item1;
import edu.paideia.hibernate.exa1.model.associations.om.ItemOM;

public class ItemService {
	private final String PU = "HelloWorldPU";
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public ItemService(){
		em = emf.createEntityManager();
	}
	
	public void save(Item item){
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	public void save(Item1 item){
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	public void save(ItemOM item){
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager emf) {
		this.em = emf;
	}
}
