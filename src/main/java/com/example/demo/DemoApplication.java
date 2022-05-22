package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	StudentRepository repository;
	
	@GetMapping("/api/v1/student")
	public List<Student> getStudents() {
		return repository.findAll();
	}
	
	@GetMapping("/api/v1/student/{id}")
	public Student getStudent(@PathVariable String id) {
		return repository.findById(Long.parseLong(id));
	}
	
	@DeleteMapping("/api/v1/student/{id}")
	public int deleteStudent(@PathVariable String id) {
		return repository.deleteById(Long.parseLong(id));
	}
	
	@PutMapping("/api/v1/student/{id}")
	public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
		// validate is id and student.id match
		repository.update(student);
		return student;
	}
	
	@PostMapping("/api/v1/student")
	public int createStudents(@RequestBody Student student) {
		return repository.insert(student);
	}
}
