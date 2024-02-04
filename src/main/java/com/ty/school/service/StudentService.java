package com.ty.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;

@Component
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}

	public Student updateStudentById(Student student, int id) {
		return studentDao.updateStudentById(student, id);
	}

	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	public Student validateStudent(String email, String password) {
		return studentDao.validateStudent(email, password);
	}

}
