package com.cupitmadland.SMS.jpa.dao;

import java.util.List;

import com.cupitmadland.SMS.jpa.entitymodels.Course;
import com.cupitmadland.SMS.jpa.entitymodels.Student;

public interface StudentDAO {
	
	List<Student> getAllStudents();
	Student getStudentbyEmail(String sEmail);
	boolean validateStudent(String sEmail, String sPassword);
	void registerStudentToCourse(String sEmail, int cId);
	List<Course> getStudentCourses(String sEmail);

}
