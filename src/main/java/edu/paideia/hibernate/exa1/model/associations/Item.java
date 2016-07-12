package edu.paideia.hibernate.exa1.model.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;


@Entity 
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ElementCollection
	@Column(name="filename")
	private Set<String> imagesSet = new HashSet<>();
	
	@ElementCollection
	@Column(name="filename")
	@org.hibernate.annotations.CollectionId(
			columns=@Column(name="image_id"),
			type=@org.hibernate.annotations.Type(type="long"),
			generator="ID_GENERATOR")
	private Collection<String> imagesBag = new ArrayList<>();
	
	@ElementCollection
	@OrderColumn
	@Column(name="filename")
	private List<String> imagesList = new ArrayList<>();
	
	@ElementCollection
	@Column(name="filename")
	@MapKeyColumn(name="name")
	private Map<String, String> imagesMap = new HashMap<>();
	
	public Item() {
		super();
	}
	
	public Item(String name) {
		this();
		this.name = name;
	}

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

	public Set<String> getImagesSet() {
		return imagesSet;
	}

	public void setImagesSet(Set<String> imagesSet) {
		this.imagesSet = imagesSet;
	}

	public Collection<String> getImagesBag() {
		return imagesBag;
	}

	public void setImagesBag(Collection<String> imagesBag) {
		this.imagesBag = imagesBag;
	}

	public List<String> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}

	public Map<String, String> getImagesMap() {
		return imagesMap;
	}

	public void setImagesMap(Map<String, String> imagesMap) {
		this.imagesMap = imagesMap;
	}
   
}
