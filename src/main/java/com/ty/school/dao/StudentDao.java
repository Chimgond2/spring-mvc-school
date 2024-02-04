package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Student;

@Component
public class StudentDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student getStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			return student;
		} else {
			return null;
		}

	}

	public boolean deleteStudentById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, id);
		if(student!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;

		}else {
			return false;
		}
	}
	public Student updateStudentById(Student student,int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Student student2=entityManager.find(Student.class, id);
		if(student2!=null) {
			student.setId(id);
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}else {
			return null;
		}
		
	}
	public List<Student> getAllStudent() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String sql="select t from Student t ";
		Query query=entityManager.createQuery(sql);
		List<Student> students=query.getResultList();
		if(students.size()>0) {
			return students;
		}else {
			return null;
		}
		
	}
	public Student validateStudent(String email,String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String sql="select r from Student r where r.email=?1 and r.password=?2";
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Student> students=query.getResultList();
		if(students.size()>0) {
			return students.get(0);
		}else {
			return null;
		}
		
		
	}


	


}
