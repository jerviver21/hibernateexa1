package edu.paideia.hibernate.exa1.model.associations;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private
	long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private
	Item1 item;
	
	public Bid(String name, Item1 item){
		this.name = name;
		this.item = item;
	}
	
	public Bid(){
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Item1 getItem() {
		return item;
	}

	public void setItem(Item1 item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
