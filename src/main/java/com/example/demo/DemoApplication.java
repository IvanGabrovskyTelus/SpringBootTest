package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/api/v1/student")
	public List<Student> hellow() {
		return List.of(
				new Student(
					1L, 
					"Ivan Gabrovsky", 
					"ivan.gabrovsky@telus.com", 
					LocalDate.of(2002, Month.JUNE, 10), 
					19), 
				new Student(
					2L, 
					"Bob Gabrovsky", 
					"bob.gabrovsky@telus.com", 
					LocalDate.of(2000, Month.JUNE, 10), 
					19),
				new Student(
					1L, 
					"Bill Gabrovsky", 
					"bill.gabrovsky@telus.com", 
					LocalDate.of(1998, Month.JUNE, 10), 
					19));
	}

}
