package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.College;
import com.anytimedeveloper.akprojects.studentStack.pojos.State;
import com.anytimedeveloper.akprojects.studentStack.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CollegeController {
    @Autowired
    private CollegeRepository collegeRepository;
    @GetMapping("/colleges")
    public Iterable<College> getAllColleges()
    {
        return collegeRepository.findAll();
    }
    @PostMapping("/colleges")
    public ResponseEntity<College> addCollege(@RequestBody College college)
    {
        College newCollege=collegeRepository.save(college);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCollege);
    }
    @GetMapping("/colleges/{id}")
    public ResponseEntity<College> getCollege(@PathVariable long id)
    {
        Optional<College> collegeOptional=collegeRepository.findById(id);
        if(collegeOptional.isPresent())
        {
            College presentCollege=collegeOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentCollege);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/colleges/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable long id,@RequestBody College college)
    {
        Optional<College> collegeOptional=collegeRepository.findById(id);
        if(collegeOptional.isPresent())
        {
            College collegePresent=collegeOptional.get();
            collegePresent.setCollegeName(college.getCollegeName());
            collegePresent.setCity(college.getCity());
            collegeRepository.save(collegePresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(collegePresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/colleges/{id}")
    public ResponseEntity<College> deleteCollege(@PathVariable long id)
    {
        Optional<College> collegeOptional=collegeRepository.findById(id);
        if(collegeOptional.isPresent())
        {
            collegeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(collegeOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/college/city/{id}")
    public Iterable<College> getCollegeByCity(@PathVariable long id)
    {
        return collegeRepository.getCollegeByCity(id);
    }
}
