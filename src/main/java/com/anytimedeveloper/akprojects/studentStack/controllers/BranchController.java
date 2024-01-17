package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.Branch;
import com.anytimedeveloper.akprojects.studentStack.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BranchController {
    @Autowired
    private BranchRepository branchRepository;
    @GetMapping("/branches")
    public Iterable<Branch> getAllBranches()
    {
        return branchRepository.findAll();
    }
    @PostMapping("/branches")
    public ResponseEntity<Branch> addbranch(@RequestBody Branch branch)
    {
        Branch newBranch=branchRepository.save(branch);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBranch);
    }
    @GetMapping("/branches/{id}")
    public ResponseEntity<Branch> getBranch(@PathVariable long id)
    {
        Optional<Branch> branchOptional=branchRepository.findById(id);
        if(branchOptional.isPresent())
        {
            Branch presentBranch=branchOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentBranch);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/branches/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable long id,@RequestBody Branch branch)
    {
        Optional<Branch> branchOptional=branchRepository.findById(id);
        if(branchOptional.isPresent())
        {
            Branch branchPresent=branchOptional.get();
            branchPresent.setTitle(branch.getTitle());
            branchRepository.save(branchPresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(branchPresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/branches/{id}")
    public ResponseEntity<Branch> deleteBranch(@PathVariable long id)
    {
        Optional<Branch> branchOptional=branchRepository.findById(id);
        if(branchOptional.isPresent())
        {
            branchRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(branchOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
