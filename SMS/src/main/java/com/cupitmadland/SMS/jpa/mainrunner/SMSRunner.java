package com.cupitmadland.SMS.jpa.mainrunner;

import java.util.Scanner;

import com.cupitmadland.SMS.jpa.entitymodels.Student;
import com.cupitmadland.SMS.jpa.service.CourseService;
import com.cupitmadland.SMS.jpa.service.StudentService;

public class SMSRunner {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		getStudentToEnterInfo();
		String studentEmail = getStudentToEnterEmailAndPassword();
		
		getValidStudentRegistered();
		getStudentToPickAClass(studentEmail);
		
		
	
		// main method to run the School Management System (instead of/like our app class)
		
		
		//create an object to use for all methods in StudentService
		StudentService obj = new StudentService();
		
		//create Student Table
		//obj.createStudentTable();
		//obj.getAllStudents();
		//obj.getStudentbyEmail("hluckham0@google.ru");
		//obj.validateStudent("cjaulme9@hello.com", "FnVklVgC6r6");
		//obj.registerStudentToCourse("hluckham0@google.ru", 1);
		//obj.registerStudentToCourse("hguerre5@deviantart.com", 4);
		//obj.getStudentCourses("aiannitti7@is.gd");
		//obj.getStudentCourses("hluckham0@google.ru");
		
		

		
		//create an object to use for all methods in CourseService
		CourseService obj2 = new CourseService();
		//obj2.createCourseTable();
		//obj2.getAllCourses();
	
	}
	public static void getStudentToEnterInfo() {
		
		
		System.out.println("Are you a student? Type 1 for Yes or 2 for No");
		int choice = input.nextInt();
		if (choice == 1) {
			System.out.println("You are a student."); //needs to continue prompting to enter email
		}else {
			System.out.println("You are not a student.");
			System.exit(0); //needs to quit
		}
		
		
	}
	
	public static String getStudentToEnterEmailAndPassword() {
		System.out.println("Please enter your email");
		String enteredEmail = input.next();
		System.out.println("Please enter your password");
		String enteredPassword = input.next();
		StudentService obj = new StudentService();
		obj.validateStudent(enteredEmail, enteredPassword);
		obj.getStudentCourses(enteredEmail);
	return enteredEmail;
	}

	
	public static void getValidStudentRegistered() {
		CourseService obj2 = new CourseService();
		System.out.println("Please enter 1 to Register to Class or enter 2 to Logout");
		int choice = input.nextInt();
		if (choice == 1) {
			obj2.getAllCourses();
			
		}else {
			System.out.println("You are being logged out.");
			System.exit(0);
		}
	}
		
	public static void getStudentToPickAClass(String studentEmail) {
		
		StudentService obj = new StudentService();
		SMSRunner e = new SMSRunner();
		
		 //trying to call email from method
		System.out.println("Please enter the course number to be registered");
		int choice = input.nextInt();
		if (choice >=1 && choice <= 10) {
			
		obj.registerStudentToCourse(studentEmail,choice);//how to pull email back, choice);
					
		obj.getStudentCourses(studentEmail);
		System.out.println("You have been signed out.");
			
		}else {
			System.out.println("You have been signed out.");
			System.exit(0);
		}
		
	}
	

	

}
