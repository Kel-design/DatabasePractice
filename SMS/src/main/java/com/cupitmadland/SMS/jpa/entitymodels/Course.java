package com.cupitmadland.SMS.jpa.entitymodels;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Course implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id @Column(name = "id", unique= true, nullable = false)
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private int cId;
	
	@Column(name = "name", nullable = false, length = 50)
	private String cName;
	
	@Column(name = "Instructor", nullable = false, length = 50)
	private String cInstructorName;
	
	//empty constructor initializing every member to initial value
	public Course() {
		this.cId = 0;
		this.cName = "";
		this.cInstructorName = "";
	}
	
	//constructor initializing every private member w/a parameter
	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	//constructor initializing cName and cInstructorName (minus the cId PK)
	public Course(String cName, String cInstructorName) {
		super();
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	//Getters & Setters for private members
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	//toString() with cId, cName & cInstructorName
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}
	
	
	
	
	
	
	
	
	

}
