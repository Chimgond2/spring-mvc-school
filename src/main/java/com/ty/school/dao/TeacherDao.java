package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dto.Teacher;

@Component
public class TeacherDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		return teacher;
	}

	public Teacher getTeacherById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Teacher teacher = entityManager.find(Teacher.class, id);
		if (teacher != null) {
			return teacher;
		} else {
			return null;
		}
	}

	public boolean deleteTeacherById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Teacher teacher = entityManager.find(Teacher.class, id);
		if (teacher != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(teacher);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Teacher updateTeacherById(Teacher teacher, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Teacher teacher2 = entityManager.find(Teacher.class, id);
		if (teacher2 != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			teacher.setId(id);
			entityManager.merge(teacher);
			entityTransaction.commit();
			return teacher;
		} else {
			return null;
		}
	}

	public List<Teacher> getAllTeacher() {
		String sql = "select y from Teacher y";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(sql);
		List<Teacher> teachers = query.getResultList();
		if (teachers.size() > 0) {
			return teachers;
		} else {
			return null;
		}

	}

	public Teacher validateTeacher(String email, String password) {

		String sql = "select y from Teacher y where y.email=?1 and y.password=?2";
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Teacher> teachers = query.getResultList();
		if (teachers.size()>0) {
			return teachers.get(0);
		} else {
			return null;
		}

	}

}
