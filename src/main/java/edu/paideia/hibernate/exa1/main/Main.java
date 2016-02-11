package edu.paideia.hibernate.exa1.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.paideia.hibernate.exa1.model.Message;

public class Main {
	private final String PU = "HelloWorldPU";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);

	public void saveMessage(String msg) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Message me = new Message();
			me.setText(msg);
			System.out.println("Before persist: "+me.getId());
			em.persist(me);
			System.out.println("Before Insert: "+me.getId());
			em.getTransaction().commit();
			System.out.println("After Insert: "+me.getId());
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readMessages() {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			List<Message> messages = em.createQuery("SELECT m FROM Message m").getResultList();
			for (Message m : messages) {
				System.out.println(m.getText());
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.saveMessage("Hola Mundo");
		main.readMessages();
	}
}
