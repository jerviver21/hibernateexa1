package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.DiscriminatorColumn;
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
import edu.paideia.hibernate.exa1.model.EmployeeIH3;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BD_TYPE")
public abstract class BillingDetailsE3 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private EmployeeIH3 employee;
	

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

	public EmployeeIH3 getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeIH3 employee) {
		this.employee = employee;
	}

}
