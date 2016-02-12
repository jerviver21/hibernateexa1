package edu.paideia.hibernate.exa1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Taller 4
 * Crear una entidad a partir de un Subselect
 */
@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
		value="SELECT c.id as ID, c.name as NAME "+
			  "FROM Category1 c"
)
@org.hibernate.annotations.Synchronize({"Category1"})
public class Category1Summary {
	
	@Id
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


}
