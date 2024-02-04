package com.ty.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.school.dao.TeacherDao;
import com.ty.school.dto.Teacher;

@Component
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;

	public Teacher saveTeacher(Teacher teacher) {
		return teacherDao.saveTeacher(teacher);
	}

	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacherById(id);
	}

	public boolean deleteTeacherById(int id) {
		return teacherDao.deleteTeacherById(id);
	}

	public Teacher updateTeacherById(Teacher teacher, int id) {
		return teacherDao.updateTeacherById(teacher, id);
	}

	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher();
	}

	public Teacher validateTeacher(String email, String password) {
		return teacherDao.validateTeacher(email, password);
	}
}
