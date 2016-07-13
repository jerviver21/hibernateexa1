package edu.paideia.hibernate.exa1.model.associations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

}
