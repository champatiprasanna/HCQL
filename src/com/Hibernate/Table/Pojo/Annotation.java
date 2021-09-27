package com.Hibernate.Table.Pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")  
public class Annotation {

	@Id 
	private int id;
	private String name, location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	

}
