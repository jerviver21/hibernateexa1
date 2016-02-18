package edu.paideia.hibernate.exa1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Category2 {
	
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private CategoryType type;
	
	//Taller6
	@org.hibernate.annotations.Formula(
			"substr(NAME, 1, 5) || '...'"
	)
	private String frag;
	
	//Taller6
	@org.hibernate.annotations.Formula(
			"(SELECT min(c.createOn) FROM Category2 c WHERE c.id= ID)"
	)
	private Date firstCreate;
	
	@Column(name="IMPERIALWEIGHT")
	@org.hibernate.annotations.ColumnTransformer(
			read = "IMPERIALWEIGHT/2.20462",
			write = "?*2.20462"
	)
	private double metricWeight;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createOn;

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

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public String getFrag() {
		return frag;
	}


	public double getMetricWeight() {
		return metricWeight;
	}

	public void setMetricWeight(double metricWeight) {
		this.metricWeight = metricWeight;
	}

	public Date getFirstCreate() {
		return firstCreate;
	}


}
