package edu.paideia.hibernate.exa1.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.Employee;
import edu.paideia.hibernate.exa1.model.EmployeeIH1;
import edu.paideia.hibernate.exa1.model.EmployeeIH2;
import edu.paideia.hibernate.exa1.model.EmployeeIH3;
import edu.paideia.hibernate.exa1.model.EmployeeIH4;

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
	
	public void save(EmployeeIH1 employee){
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}
	
	public void save(EmployeeIH2 employee){
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}
	
	public void save(EmployeeIH3 employee){
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}
	
	public void save(EmployeeIH4 employee){
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}
	
	public Employee getEmployeeByName(String name){
		return (Employee)em.createNamedQuery("employeeByName").setParameter("name", name).getSingleResult();
	}
	
	public EmployeeIH1 getEmployee1ByName(String name){
		return (EmployeeIH1)em.createNamedQuery("employee1ByName").setParameter("name", name).getSingleResult();
	}
	
	public EmployeeIH2 getEmployee2ByName(String name){
		return (EmployeeIH2)em.createNamedQuery("employee2ByName").setParameter("name", name).getSingleResult();
	}
	
	public EmployeeIH3 getEmployee3ByName(String name){
		return (EmployeeIH3)em.createNamedQuery("employee3ByName").setParameter("name", name).getSingleResult();
	}
	
	public EmployeeIH4 getEmployee4ByName(String name){
		return (EmployeeIH4)em.createNamedQuery("employee4ByName").setParameter("name", name).getSingleResult();
	}

}