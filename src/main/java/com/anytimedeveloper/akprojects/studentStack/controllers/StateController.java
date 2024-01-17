package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.State;
import com.anytimedeveloper.akprojects.studentStack.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StateController {
    @Autowired
    private StateRepository stateRepository;
    @GetMapping("/states")
    public Iterable<State> getAllStates()
    {
        return stateRepository.findAll();
    }
    @PostMapping("/states")
    public ResponseEntity<State> addState(@RequestBody State state)
    {
        State newState=stateRepository.save(state);
        return ResponseEntity.status(HttpStatus.CREATED).body(newState);
    }
    @GetMapping("/states/{id}")
    public ResponseEntity<State> getState(@PathVariable long id)
    {
        Optional<State> stateOptional=stateRepository.findById(id);
        if(stateOptional.isPresent())
        {
            State presentState=stateOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentState);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/states/{id}")
    public ResponseEntity<State> updateState(@PathVariable long id,@RequestBody State state)
    {
        Optional<State> stateOptional=stateRepository.findById(id);
        if(stateOptional.isPresent())
        {
            State statePresent=stateOptional.get();
            statePresent.setStateName(state.getStateName());
            statePresent.setCountry(state.getCountry());
            stateRepository.save(statePresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(statePresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/states/{id}")
    public ResponseEntity<State> deleteState(@PathVariable long id)
    {
        Optional<State> stateOptional=stateRepository.findById(id);
        if(stateOptional.isPresent())
        {
            stateRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(stateOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/states/country/{id}")
    public Iterable<State> getStateByCountry(@PathVariable long id)
    {
        return stateRepository.getStateByCountry(id);
    }
}
