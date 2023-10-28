package com.cupitmadland.hibernateuser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.hibernateuser.util.HibernateUtil;

@NamedQueries({
	@NamedQuery(name = "updateMyuser", query = "UPDATE User SET fullName = :fullname WHERE id = :id")
	
})

@Entity
@Table(name= "users")
public class User {
	
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String fullname;
	private String email;
	private String password;
	private int age;
	private double salary;
	private String city;
	
	public User() {
		this.fullname= "";
		this.email = "";
		this.password = "";
		this.age = 0;
		this.salary = 0.0;
		this.city = "";
	}
	
	

	public User(String fullname, String email, String password, int age, double salary, String city) {
		//no id needed here because it's already auto generated and you can still get id from getters/setters
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.age = age;
		this.salary = salary;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", age="
				+ age + ", salary=" + salary + ", city=" + city + "]";
	}
	
	

}
