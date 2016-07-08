package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

//Debido a que no se trata de un entity, no permite aplicar caracteristicas polimorficas
@MappedSuperclass
public abstract class BillingDetailsE1 {
	
	@NotNull
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
