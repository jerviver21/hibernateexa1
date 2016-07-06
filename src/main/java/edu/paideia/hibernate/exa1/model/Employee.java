package edu.paideia.hibernate.exa1.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.config.MonetaryAmountConverter;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE1;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE2;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE1;

//Taller7
@Entity
@NamedQueries({
	@NamedQuery(
			name="employeeByName", 
			query="SELECT c FROM Employee c WHERE c.name = :name"
	)
})

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	private Address address;
	
	@AttributeOverrides({
			@AttributeOverride(name="street", column=@Column(name="ALTER_STREET")),
			@AttributeOverride(name="number", column=@Column(name="ALTER_NUMBER"))
	})
	private Address alterAddress;
	
	
	//Taller8
	@NotNull
	@Convert(
			converter = MonetaryAmountConverter.class,
			disableConversion = false
	)
	@Column(name="SALARY", length=100)
	private MonetaryAmount salary;
	
	
	//Taller9: Permite implementación de herencia de forma polimórfica, El query lo hace con una unión.
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL})
	private List<BillingDetailsE2> account;
	
	//Taller9: No permite imp de forma polimorfica, puesto que la clase padre no es una entidad
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL})
	private List<CreditCardE1> creditCard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAlterAddress() {
		return alterAddress;
	}

	public void setAlterAddress(Address alterAddress) {
		this.alterAddress = alterAddress;
	}

	public MonetaryAmount getSalary() {
		return salary;
	}

	public void setSalary(MonetaryAmount salary) {
		this.salary = salary;
	}

	public List<BillingDetailsE2> getAccount() {
		return account;
	}

	public void setAccount(List<BillingDetailsE2> account) {
		this.account = account;
	}

	public List<CreditCardE1> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(List<CreditCardE1> creditCard) {
		this.creditCard = creditCard;
	}
	

}