package com.cupitmadland.SMS.jpa.entitymodels;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name = "email", unique = true, nullable = false, length = 50)
	private String sEmail;
	
	@Column(name = "name", nullable = false, length = 50)
	private String sName;
	
	@Column(name = "password", nullable = false, length = 50)
	private String sPassword;
	
	//TODO: come back and add @OneToMany private List sCourses; along with constructors & toString
	@OneToMany(targetEntity=Course.class, cascade = {CascadeType.ALL})
	private List<Course> sCourses;
	
	//empty constructor initializing every member to initial value
	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPassword = "";
	}
	
	//constructor initializing every initial private member w/a parameter
	public Student(String sEmail, String sName, String sPassword) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
	}

	//constructor initializing sName and sPassword (minus the sEmail PK)
	public Student(String sName, String sPassword) {
		super();
		this.sName = sName;
		this.sPassword = sPassword;
	}
	
	//constructor initializing ALL private members (including newly added sCourses)
	public Student(String sEmail, String sName, String sPassword, List sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sCourses = sCourses;
	}
	
	//adding Getters & Setters for sCourses
	
	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List sCourses) {
		this.sCourses = sCourses;
	}
	
	
	
	//Getters & Setters for private members
	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	

	//toString() with sEmail, sName & sPassword
	//@Override
	//public String toString() {
		//return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPassword=" + sPassword + "]";
	//}
	
	//made new toString with sEmail, sName, sPassword & sCourses
	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPassword=" + sPassword + ", sCourses=" + sCourses
				+ "]";
	}
	
	
	
	
	
	
	
	
}
