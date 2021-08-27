package com.netsurfingzone.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netsurfingzone.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {

}