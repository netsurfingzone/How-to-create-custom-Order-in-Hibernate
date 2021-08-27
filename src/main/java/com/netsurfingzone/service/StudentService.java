package com.netsurfingzone.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.netsurfingzone.entity.Student;

@Component
public interface StudentService {
	public List<Student> saveStudent(List<Student> studentList);

	public List<Student> findAll();
}