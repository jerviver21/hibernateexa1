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
			name="category2ByName", 
			query="SELECT c FROM Category2 c WHERE c.name = :name"
	),
	@org.hibernate.annotations.NamedQuery(
			name="categoryByDate", 
			query="SELECT c FROM Category1 c WHERE c.expiredDate = :date"
	)
	
	
})

//Taller5: Creación de un generador para la generación de identidad
@org.hibernate.annotations.GenericGenerator(
		name="ID_GENERATOR",
		strategy="enhanced-sequence",
		parameters={
				@org.hibernate.annotations.Parameter(
						name="sequence_name",
						value="GEN1_SEQ"
				),
				@org.hibernate.annotations.Parameter(
						name="initial_value",
						value="1000"
				)
		}
)
package edu.paideia.hibernate.exa1.model;

