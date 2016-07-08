package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.model.Employee;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BillingDetailsE2 {
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	private Long id;
	
	@NotNull
	private String owner;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
