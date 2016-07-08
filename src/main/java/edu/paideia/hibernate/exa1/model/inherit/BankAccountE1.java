package edu.paideia.hibernate.exa1.model.inherit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import edu.paideia.hibernate.exa1.model.Employee;
import edu.paideia.hibernate.exa1.model.EmployeeIH1;


@Entity
public class BankAccountE1 extends BillingDetailsE1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String accountNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private EmployeeIH1 employee;
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String cardNumber) {
		this.accountNumber = cardNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeIH1 getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeIH1 employee) {
		this.employee = employee;
	}

}
