package edu.paideia.hibernate.exa1.model.associations.om;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class CategoryOM1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private
	long id;
	
	private String name;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Set<ItemOM> items = new HashSet<>();

	public Set<ItemOM> getItems() {
		return items;
	}

	public void setItems(Set<ItemOM> items) {
		this.items = items;
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

}
