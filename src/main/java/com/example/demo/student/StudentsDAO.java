package com.example.demo.student;

import java.util.List;

import org.springframework.context.annotation.Bean;

public class StudentsDAO {
	
	public StudentsDAO(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	private StudentRepository repository;
	
	
	
	@Bean
	public List<Student> getAllStudents() {
		return repository.findAll();
	}
}
