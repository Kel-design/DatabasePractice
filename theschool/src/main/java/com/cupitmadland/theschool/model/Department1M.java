package com.cupitmadland.theschool.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department1M implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depId;
	private String deptName;
	
	@OneToMany(targetEntity = Teacher1M.class, cascade =(CascadeType.ALL))
	private List teacherList;
	
	public Department1M() {
		
	}

	public Department1M(int depId, String deptName) {
		super();
		this.depId = depId;
		this.deptName = deptName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return "Department1M [depId=" + depId + ", deptName=" + deptName + ", teacherList=" + teacherList + "]";
	}
	
	

}
