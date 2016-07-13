package edu.paideia.hibernate.exa1.model.associations;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Image {
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String filename;
	
	protected int width;
	
	protected int height;
	
	public Image(){
		
	}
	
	public Image(String title, String filename, int w, int h){
		this.title = title;
		this.filename = filename;
		this.width = w;
		this.height = h;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Image other = (Image) o;
	
		if(!title.equals(other.title)) return false;
		if(!filename.equals(other.filename)) return false;
		if(width != other.width) return false;
		if(height != other.height) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = title.hashCode();
		result = 31 * result + filename.hashCode();
		result = 31 * result + width;
		result = 31 * result + height;
		return result;
	}
	
	
	

}
