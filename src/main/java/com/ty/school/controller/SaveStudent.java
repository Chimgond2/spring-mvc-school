package com.ty.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.school.dto.Student;
import com.ty.school.service.StudentService;

@Controller
public class SaveStudent {
	@Autowired
	StudentService studentService;

	@GetMapping("/loadstudent")
	public ModelAndView loadUser() {
		ModelAndView andView = new ModelAndView("createstudent.jsp");
		andView.addObject("stud", new Student());

		return andView;
	}

	@PostMapping("/savestudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		Student student2 = studentService.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		if (student2 != null) {
			modelAndView.addObject("message", "student name is: " + student.getName() + " is saved");
		} else {
			modelAndView.addObject("message", "student name is: " + student.getName() + " is not saved");

		}

		return modelAndView;
	}

	@GetMapping("/loadstudenturl")
	public ModelAndView listOfStudent() {
		ModelAndView modelAndView = new ModelAndView("displaylistofstudents.jsp");
		List<Student> students = studentService.getAllStudent();
		// modelAndView.addObject("student",students);
		if (students != null) {
			modelAndView.addObject("student", students);
		} else {

		}
		return modelAndView;
	}

	@GetMapping("/loadeditstudent")
	public ModelAndView editStudent() {
		ModelAndView modelAndView = new ModelAndView("edit.jsp");
		modelAndView.addObject("edit", new Student());
		return modelAndView;
	}

	@PostMapping("/updatestudent")
	public ModelAndView editStudent(@ModelAttribute Student student, @RequestParam(name="id") int id) {
		Student student2 = studentService.updateStudentById(student, id);
		ModelAndView modelAndView = new ModelAndView("displaylistofstudents.jsp");
		if (student2 != null) {
			modelAndView.addObject("message", "student name is: " + student.getName() + " is updated");
		} else {
			modelAndView.addObject("message", "student name is: " + student.getName() + " is not updated");

		}

		return modelAndView;
	}

}
