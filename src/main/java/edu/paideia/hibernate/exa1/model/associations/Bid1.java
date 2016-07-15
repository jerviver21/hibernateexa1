package edu.paideia.hibernate.exa1.model.associations;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Bid1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private
	long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinTable(
			name="bid_user",
			joinColumns=@JoinColumn(name="bid_id"),
			inverseJoinColumns=@JoinColumn(nullable=false)
	)
	private User usr;
	

	
	public Bid1(String name, User usr){
		this.name = name;
		this.usr = usr;
	}
	
	public Bid1(){
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

}
