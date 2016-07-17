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
public class ItemOM {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private long price;
	
	@ManyToMany(mappedBy="items")
	private Set<CategoryOM1> categories = new HashSet<>();
	
	public ItemOM(){
		
	}
	
	public ItemOM(String name, long price){
		this.name = name;
		this.price = price;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Set<CategoryOM1> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryOM1> categories) {
		this.categories = categories;
	}

}
