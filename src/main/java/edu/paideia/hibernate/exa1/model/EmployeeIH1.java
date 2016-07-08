package edu.paideia.hibernate.exa1.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.config.MonetaryAmountConverter;
import edu.paideia.hibernate.exa1.model.inherit.BankAccountE1;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE1;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE2;
import edu.paideia.hibernate.exa1.model.inherit.BillingDetailsE3;
import edu.paideia.hibernate.exa1.model.inherit.CreditCardE1;

@Entity
@NamedQueries({
	@NamedQuery(
			name="employee1ByName", 
			query="SELECT c FROM EmployeeIH1 c WHERE c.name = :name"
	)
})

public class EmployeeIH1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<CreditCardE1> creditCards;
	
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private List<BankAccountE1> accounts;

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

	public List<CreditCardE1> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCardE1> creditCard) {
		this.creditCards = creditCard;
	}

	public List<BankAccountE1> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccountE1> accounts) {
		this.accounts = accounts;
	}

}