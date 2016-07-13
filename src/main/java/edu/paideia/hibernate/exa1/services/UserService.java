package edu.paideia.hibernate.exa1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.associations.User;

public class UserService {
	private final String PU = "HelloWorldPU";
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public UserService(){
		em = emf.createEntityManager();
	}
	
	public void save(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager emf) {
		this.em = emf;
	}
}
