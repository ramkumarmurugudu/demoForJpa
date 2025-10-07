package com.example.demoForJpa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoForJpa.entity.Student;

@RestController
public class StudentController {
	
	@PostMapping("api/students")
	public void saveStudent(@RequestBody Student student) {
     System.out.println(student);
}

}
