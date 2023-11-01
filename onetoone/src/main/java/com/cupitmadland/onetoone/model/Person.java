package com.cupitmadland.onetoone.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Person implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int PersonId;
	private String name;
	private String email;
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public Person() {
		
	}

	public Person(int personId, String name, String email, int age, Address address) {
		super();
		PersonId = personId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	public int getPersonId() {
		return PersonId;
	}

	public void setPersonId(int personId) {
		PersonId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [PersonId=" + PersonId + ", name=" + name + ", email=" + email + ", age=" + age + ", address="
				+ address + "]";
	}
	
}
