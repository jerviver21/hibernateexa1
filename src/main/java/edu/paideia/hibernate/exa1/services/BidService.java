package edu.paideia.hibernate.exa1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.associations.Bid1;

public class BidService {
	private final String PU = "HelloWorldPU";
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public BidService(){
		em = emf.createEntityManager();
	}
	
	public void save(Bid1 bid){
		em.getTransaction().begin();
		em.persist(bid);
		em.getTransaction().commit();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager emf) {
		this.em = emf;
	}
}
