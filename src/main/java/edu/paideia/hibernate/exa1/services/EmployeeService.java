package edu.paideia.hibernate.exa1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.Employee;

public class EmployeeService {
	
	private final String PU = "HelloWorldPU";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
	EntityManager em;
	
	public EmployeeService(){
		em = emf.createEntityManager();
	}
	
	public void save(Employee employee){
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}

}
