/*
 * Taller1
 * Ejemplo de anotaciones de paquete, las cuales son permitidas en Hibernate
 */

@org.hibernate.annotations.NamedQueries({
	@org.hibernate.annotations.NamedQuery(
			name="categoryByName", 
			query="SELECT c FROM Category1 c WHERE c.name = :name"
	),
	@org.hibernate.annotations.NamedQuery(
			name="categoryByDate", 
			query="SELECT c FROM Category1 c WHERE c.expiredDate = :date"
	)
	
})
package edu.paideia.hibernate.exa1.model;

