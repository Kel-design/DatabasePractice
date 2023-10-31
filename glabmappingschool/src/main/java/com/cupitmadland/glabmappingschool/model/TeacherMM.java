package com.cupitmadland.glabmappingschool.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class TeacherMM implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tit;
	private String salary;
	private String Teachername;
	
	@ManyToMany(targetEntity = Cohort.class)
	private Set CohortSet;
	
	public TeacherMM() {
		
	}

	public TeacherMM(String salary, String teachername,Set cohortSet) {
		super();
		this.salary = salary;
		Teachername = teachername;
		this.CohortSet = cohortSet;
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

	public Set getCohortSet() {
		return CohortSet;
	}

	public void setCohortSet(Set cohortSet) {
		CohortSet = cohortSet;
	}

	@Override
	public String toString() {
		return "TeacherMM [tit=" + tit + ", salary=" + salary + ", Teachername=" + Teachername + ", CohortSet="
				+ CohortSet + "]";
	}
	
	
	
	

}
