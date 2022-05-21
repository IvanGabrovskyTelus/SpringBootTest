package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	private List<Student> studentsList = List.of(
				new Student(
					1L, 
					"Ivan Gabrovsky", 
					"ivan.gabrovsky@telus.com", 
					LocalDate.of(2002, Month.JUNE, 10), 
					19), 
				new Student(
					2L, 
					"Bob Proktor", 
					"bob.proktor@telus.com", 
					LocalDate.of(2000, Month.MAY, 1), 
					19),
				new Student(
					3L, 
					"Bill Smith", 
					"bill.smith@telus.com", 
					LocalDate.of(1998, Month.JANUARY, 21), 
					19));
	
	@Bean
	@GetMapping("/api/v1/student")
	public List<Student> getStudents(StudentRepository repository) {
		return repository.findAll(); // studentsList;
	}
	
	@GetMapping("/api/v1/student/{id}")
	public Student getStudent(@PathVariable String id) {
		Student student = studentsList
				.stream()
				.filter( s -> s.getId() == Long.parseLong(id))
				.findFirst()
				.orElse(null);
		return student;
	}
	
//	@Bean
//	public List<Student> getAllStudents(StudentRepository repository) {
//		return repository.findAll();
//	}
}
