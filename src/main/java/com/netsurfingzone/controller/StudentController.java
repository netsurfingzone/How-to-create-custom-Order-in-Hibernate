package com.netsurfingzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public List<Student> saveBook(@RequestBody List<Student> studentList) {
		List<Student> studentResponse = (List<Student>) studentService.saveStudent(studentList);
		return studentResponse;
	}

	@RequestMapping(value = "/allstudents", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudents() {
		List<Student> studentList = (List<Student>) studentService.findAll();
		return studentList;
	}

}