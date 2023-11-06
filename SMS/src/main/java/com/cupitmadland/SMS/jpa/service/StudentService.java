package com.cupitmadland.SMS.jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.cupitmadland.SMS.jpa.dao.StudentDAO;
import com.cupitmadland.SMS.jpa.entitymodels.Course;
import com.cupitmadland.SMS.jpa.entitymodels.Student;
import com.cupitmadland.SMS.jpa.service.*;

public class StudentService implements StudentDAO {

	// create Student Table

	public void createStudentTable() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();

		Student student = new Student(); // mapping file referring to config file to create table
		t.commit();
		System.out.println("Successfully created Student table");
		session.close();
	}

	// reads the Student table in db and returns the data as a List<Student>
	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student";
		Query<Student> query = session.createQuery(hql, Student.class);
		List<Student> results = query.getResultList();

		for (Student s : results) {
			System.out.println("Student email: " + s.getsEmail() + " |" + "name: " + s.getsName() + " |" + "password: "
					+ " |" + s.getsPassword());
		}
		return results;
	}

	// method takes in student email and returns one student
	@Override
	public Student getStudentbyEmail(String sEmail) {
		Session session = HibernateUtil.getConnection();

		Student s = session.get(Student.class, sEmail);
		System.out.println("Student email: " + s.getsEmail() + " |" + "name: " + s.getsName());

		return s;
	}

	// method checks if student email AND student password are in student table.
	// Returns false if not present, true if match
	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student s WHERE s.sEmail = :email AND s.sPassword = :password";

		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email", sEmail);
		query.setParameter("password", sPassword);
		Student result = query.getSingleResultOrNull();
		if (result != null) {
			System.out.println("Your email and password are correct");
			return true;

		} else {
			System.out.println("Your email and password are incorrect");
			return false;
		}

	}

	// checks if student email is already in Cid list. if so they are told they are
	// already registered. If not they can be registered.
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();

		Student s = this.getStudentbyEmail(sEmail);

		boolean isCourseMatchFound = false;

		for (Course c : s.getsCourses()) {
			if (c.getcId() == cId) {
				isCourseMatchFound = true;
				System.out.println("You are already registered in that course!");

			}
		}
		if (isCourseMatchFound == false) {
			System.out.println("You need to be registered.");
			this.addStudentToCourse(s, cId);
			session.merge(s);
			t.commit();

			session.close();
		}

	}

	// helper method for registerStudentToCourse. It adds student to course if they
	// are eligible to register (have email & not found in cId)
	public void addStudentToCourse(Student s, int cId) {

		Course c = CourseService.getCourseById(cId);
		s.getsCourses().add(c);

	}

	// get student by email (using method above) and returning the list of sCourses
	// from join table
	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Student s = this.getStudentbyEmail(sEmail);

		List<Course> studentList = s.getsCourses();
		System.out.println("My Classes: " + s.getsCourses());
		return studentList;

	}
}
