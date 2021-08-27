package com.netsurfingzone.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.repository.StudentRepository;
import com.netsurfingzone.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<Student> saveStudent(List<Student> studentList) {
		List<Student> response = (List<Student>) studentRepository.saveAll(studentList);
		return response;
	}

	@Transactional
	public List<Student> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Student.class);
		criteria.addOrder(CustomOrder.addCustomOrder("studentName", true));

		// for normal ordering
		// criteria.addOrder(Order.asc("studentName"));

		List<Student> studentList = criteria.list();
		return studentList;
	}

}