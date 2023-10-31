package com.cupitmadland.glabmappingschool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tit;
	private String salary;
	private String Teachername;

	@ManyToOne
	@JoinColumn(name = "fk_dep")
	private Department department;

	public Teacher() {

	}

	public Teacher(String salary, String teachername) {
		super();

		this.salary = salary;
		Teachername = teachername;

	}

	public int getTit() {
		return tit;
	}

	public void setTit(int tit) {
		this.tit = tit;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeachername() {
		return Teachername;
	}

	public void setTeachername(String teachername) {
		Teachername = teachername;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Teacher [tit=" + tit + ", salary=" + salary + ", Teachername=" + Teachername + ", department="
				+ department + "]";
	}

	

}
