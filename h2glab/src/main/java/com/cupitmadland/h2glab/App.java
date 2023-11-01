package com.cupitmadland.h2glab;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.h2glab.model.Student;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Student student = new Student("Haseeb", "Muhammad", "mhaseebe@mail.com");
		Student student1 = new Student("John", "Cena", "john@mail.com");
		Student student2 = new Student("Jennifer", "Bai", "jBaji@mail.com");

		session.save(student);
		session.save(student1);
		session.save(student2);
		t.commit();

		String hql = "SELECT s FROM Student s";
		Query query = session.createQuery(hql);
		List<Student> list = query.getResultList();

		for (Student stu : list) {
			System.out.println("Student Id: " + stu.getId() + " | First name: " + stu.getFirstName() + " | LastName: "
					+ stu.getLastName() + " | Email: " + stu.getEmail());
		}

	}
}
