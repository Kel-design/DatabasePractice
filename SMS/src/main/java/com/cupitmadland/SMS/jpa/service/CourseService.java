package com.cupitmadland.SMS.jpa.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cupitmadland.SMS.jpa.dao.CourseDAO;
import com.cupitmadland.SMS.jpa.entitymodels.Course;
import com.cupitmadland.SMS.jpa.entitymodels.Student;

public class CourseService implements CourseDAO{

	// create Course Table
	
	public void createCourseTable() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Course course = new Course();
		t.commit();
		System.out.println("Successfully created Course table");
		session.close();
	}
	
	
	//helper method to get one course by Id
	public static Course getCourseById(int cId) {
		Session session = HibernateUtil.getConnection();
		Course c = session.get(Course.class, cId);
		System.out.println("Course Id: " + c.getcId() + " |" + "name: " + c.getcName());

		return c;
	}
	
	//getting a list of all courses in Course Table
	@Override
	public List<Course> getAllCourses() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Course";
		Query<Course> query = session.createQuery(hql, Course.class);
		List<Course> results = query.getResultList();

		for (Course c : results) {
			System.out.println("COURSE ID: " + c.getcId() + " |" + "COURSE NAME: " + c.getcName() + " |" + "INSTRUCTOR NAME: "
					+ " |" + c.getcInstructorName());
		}
		return results;

}}
