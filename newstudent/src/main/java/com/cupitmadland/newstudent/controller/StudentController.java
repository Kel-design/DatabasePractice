package com.cupitmadland.newstudent.controller;

import com.cupitmadland.newstudent.model.Student;
import com.cupitmadland.newstudent.view.StudentView;

public class StudentController {
	
	private Student model;
	private StudentView view;
	
	
	public Student getModel() {
		return model;
	}


	public void setModel(Student model) {
		this.model = model;
	}


	public StudentView getView() {
		return view;
	}


	public void setView(StudentView view) {
		this.view = view;
	}


	public StudentController(Student model, StudentView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void updateView() {
		view.printStudentDetails(model.getName(), model.getRollnum());
	}

}
