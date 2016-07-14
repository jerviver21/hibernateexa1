package edu.paideia.hibernate.exa1.model.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity 
public class Item1 implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="item", cascade=CascadeType.PERSIST)
	private
	Collection<Bid> bids = new ArrayList<>();
	
	public Item1() {
		super();
	}
	
	public Item1(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Bid> getBids() {
		return bids;
	}

	public void setBids(Collection<Bid> bids) {
		this.bids = bids;
	}

}
