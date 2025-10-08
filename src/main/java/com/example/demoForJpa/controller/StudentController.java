package com.example.demoForJpa.controller;

import com.example.demoForJpa.entity.Student;
import com.example.demoForJpa.repo.StudentRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@RestController
public class StudentController {
	
	@Autowired
	 private StudentRepo studentRepo;
	
	@PostMapping("api/students")
	public Student saveStudent(@RequestBody Student student) {
     return studentRepo.save(student);
     
}
	@GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
}

	 @GetMapping("/api/students/{id}")
	    public Optional<Student> getStudentById(@PathVariable Long id) {
	        return studentRepo.findById(id);
	    }
	 
	 @PutMapping("/api/students/{id}")
	 public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	     return studentRepo.findById(id).map(student -> {
	         student.setStudentName(studentDetails.getStudentName());
	         student.setStudentEmail(studentDetails.getStudentEmail());
	         student.setStudentAddress(studentDetails.getStudentAddress());
	         return studentRepo.save(student);
	     });
	 }
	 
	 @DeleteMapping("/api/students/{id}")
	 public Optional<Student> deleteStudent(@PathVariable Long id) {
	     return studentRepo.findById(id).map(student -> {
	         studentRepo.delete(student);
	         return student;
	     });
	 }

}