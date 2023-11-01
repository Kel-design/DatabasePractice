package com.cupitmadland.theschool.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "teachmm")
public class TeacherMM implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String salary;
	private String teacherName;
	
	@ManyToMany(targetEntity = Cohort.class) //setting many to many on the private Set cohortSet in the Cohort class
	private Set cohortSet;
	
	public TeacherMM() {
		
	}

	public TeacherMM(String salary, String teacherName, Set cohortSet) {
		super();
		this.salary = salary;
		this.teacherName = teacherName;
		this.cohortSet = cohortSet;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set getCohortSet() {
		return cohortSet;
	}

	public void setCohortSet(Set cohortSet) {
		this.cohortSet = cohortSet;
	}

	@Override
	public String toString() {
		return "TeacherMM [teacherId=" + teacherId + ", salary=" + salary + ", teacherName=" + teacherName
				+ ", cohortSet=" + cohortSet + "]";
	}
	
	

}
