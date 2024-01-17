package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.Student;
import com.anytimedeveloper.akprojects.studentStack.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/students")
    public Iterable<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        Student newStudent=studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id)
    {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            Student presentStudent=studentOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentStudent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student)
    {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            Student studentPresent=studentOptional.get();
            studentPresent.setStudentName(student.getStudentName());
            studentPresent.setBranch(student.getBranch());
            studentPresent.setCountry(student.getCountry());
            studentPresent.setState(student.getState());
            studentPresent.setCity(student.getCity());
            studentPresent.setCollege(student.getCollege());
            studentPresent.setDateOfbirth(student.getDateOfbirth());
            studentPresent.setEmailId(student.getEmailId());
            studentPresent.setPhoneNo(student.getPhoneNo());
            studentPresent.setGender(student.getGender());
            studentPresent.setIndian(student.isIndian());
            studentRepository.save(studentPresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentPresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id)
    {
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
