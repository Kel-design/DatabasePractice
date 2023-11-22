package com.cupitmadland.newstudent.model;

public class Student {
	
	private String rollnum;
	private String name;
	
	public Student(){}
	
	
	public String getRollnum() {
		return rollnum;
	}
	public void setRollnum(String rollnum) {
		this.rollnum = rollnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String rollnum, String name) {
		super();
		this.rollnum = rollnum;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollnum=" + rollnum + ", name=" + name + "]";
	}
	
	

}
