package com.cupitmadland.glabmappingschool.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cupitmadland.glabmappingschool.model.Address;
import com.cupitmadland.glabmappingschool.model.Cohort;
import com.cupitmadland.glabmappingschool.model.Department;
import com.cupitmadland.glabmappingschool.model.Teacher;
import com.cupitmadland.glabmappingschool.model.Teacher1M;
import com.cupitmadland.glabmappingschool.model.TeacherMM;
import com.cupitmadland.glabmappingschool.model.Department1M;
import com.cupitmadland.glabmappingschool.model.Person;



public class GenerateDataUtil {
	
	public void createDataManyToOne() {
		
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Department dep = new Department();
		dep.setDname("IT");
		
		Department dep2 = new Department();
		dep.setDname("HR");
		
		Teacher t1 = new Teacher();
		t1.setDepartment(dep);
		t1.setSalary("1000");
		t1.setTeachername("MHaseeb");
		
		Teacher t2 = new Teacher();
		t2.setDepartment(dep);
		t2.setSalary("2220");
		t2.setTeachername("Shahparan");
		
		Teacher t3 = new Teacher();
		t3.setDepartment(dep);
		t3.setSalary("30000");
		t3.setTeachername("James");
		
		Teacher t4 = new Teacher();
		t4.setDepartment(dep2);
		t4.setSalary("40000");
		t4.setTeachername("Joseph");
		
		session.persist(dep);
		session.persist(dep2);
		
		session.persist(t1);
		session.persist(t2);
		session.persist(t3);
		session.persist(t4);
		t.commit();
		
		
	}
	
	public static void createDataOneToMany() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Teacher1M t1 = new Teacher1M();
		t1.setTeachername("Haseeb");
		t1.setSalary("100");

		Teacher1M t2 = new Teacher1M();
		t2.setTeachername("Jenny Finch");
		t2.setSalary("10000");
	
		Teacher1M t3 = new Teacher1M();
		t3.setTeachername("James");
		t3.setSalary("25000");
	
		Teacher1M t4 = new Teacher1M();
		t4.setTeachername("SID ROSE");
		t4.setSalary("3000");
		
		Teacher1M t5 = new Teacher1M();
		t5.setSalary("200");
		t5.setTeachername("Ali");
		
		
		List<Teacher1M> teachList = new ArrayList<Teacher1M>();
		
		teachList.add(t1);
		teachList.add(t2);
		teachList.add(t3);
		teachList.add(t4);
		teachList.add(t5);
		
		session.persist(t1);
		session.persist(t2);
		session.persist(t3);
		session.persist(t4);
		session.persist(t5);
		 
		Department1M department = new Department1M(); 
		department.setDname("Development");
		department.setTeacherList(teachList);
		
		session.persist(department);
		t.commit();


	}
	
	public static void createDataOneToOne() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Address a1 = new Address();
		a1.setCity("nyc");
		a1.setState("NY");
		a1.setStreet("27th street");
		a1.setZipcode(11103);
		
		Address a2 = new Address();
		a2.setCity("Bufflo");
		a2.setState("NY");
		a2.setStreet("28th street");
		a2.setZipcode(15803);
		
		Person p1 = new Person();
		p1.setAge(25);
		p1.setEmail("e.jon@email.com");
		p1.setName("elbert Adam");
		p1.setAddress(a1);
		
		Person p2 = new Person();
		p2.setAge(45);
		p2.setEmail("ch.fink@email.com");
		p2.setName("Christ fink");
		p2.setAddress(a2);
		
		session.persist(p1);
		session.persist(p2);
		session.persist(a1);
		session.persist(a2);
		t.commit();

		
	}
	
	public static void createDataManyToMany() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Cohort Class1 = new Cohort("Java Developer", "14 weeks");
		Cohort Class2 = new Cohort("FullStack Developer", "7 Weeks");
		Cohort Class3 = new Cohort("Python Developer", "12 Weeks");
		
		session.persist(Class1);
		session.persist(Class2);
		session.persist(Class3);
		
		Set<Cohort> ClassSet1 = new HashSet<Cohort>();
		ClassSet1.add(Class1);
		ClassSet1.add(Class2);
		ClassSet1.add(Class3);
		
		Set<Cohort> ClassSet2 = new HashSet<Cohort>();
		ClassSet2.add(Class2);
		ClassSet2.add(Class3);
		ClassSet2.add(Class1);
		
		Set<Cohort> ClassSet3 = new HashSet<Cohort>();
		ClassSet3.add(Class3);
		ClassSet3.add(Class1);
		ClassSet3.add(Class2);
		
		TeacherMM t1 = new TeacherMM("100", "Haseeb", ClassSet1);
		TeacherMM t2 = new TeacherMM("200", "Jenny", ClassSet2);
		TeacherMM t3 = new TeacherMM("200", "Charlie", ClassSet3);
		
		session.persist(t1);
		session.persist(t2);
		session.persist(t3);
		t.commit();	 
		}

		
		

		
		
	}


