package com.cupitmadland.SMS.jpa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.cupitmadland.SMS.jpa.entitymodels.Student;
import com.cupitmadland.SMS.jpa.service.StudentService;

public class GetStudentByEmailTest {
	
	private static StudentService studentService;
	
	@Test
	public void testGetStudentByEmail() {
		studentService = new StudentService();
		Student expectedStudent = new Student();
		
		//need to enter below null values for student testing
		expectedStudent.setsEmail("hluckham0@google.ru");
		expectedStudent.setsName("Hazel Luckham");
		expectedStudent.setsPassword("X1uZcoIh0dj");
		
		//what is actually in the database TODO: ADD EMAIL TO NULL HOLDER
		Student actualStudent = studentService.getStudentbyEmail("hluckham0@google.ru");
		
		assertEquals(expectedStudent.getsEmail(), actualStudent.getsEmail());
		
	}

}
