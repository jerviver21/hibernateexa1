package edu.paideia.hibernate.exa1.model.associations;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	//@GeneratedValue(generator = "ID_GENERATOR")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne(
		fetch = FetchType.LAZY,
		optional = false,
		cascade = CascadeType.PERSIST
	)
	@JoinColumn(unique = true)
	private Address1 shippingAddress;
	
	
	@OneToMany(mappedBy="usr", cascade=CascadeType.PERSIST)
	private
	Set<Bid1> bids = new HashSet<>();
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address1 getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address1 shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bid1> getBids() {
		return bids;
	}

	public void setBids(Set<Bid1> bids) {
		this.bids = bids;
	}

}
