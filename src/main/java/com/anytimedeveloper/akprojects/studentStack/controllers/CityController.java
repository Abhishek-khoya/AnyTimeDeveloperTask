package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.City;
import com.anytimedeveloper.akprojects.studentStack.pojos.State;
import com.anytimedeveloper.akprojects.studentStack.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @GetMapping("/cities")
    public Iterable<City> getAllCities()
    {
        return cityRepository.findAll();
    }
    @PostMapping("/cities")
    public ResponseEntity<City> addCity(@RequestBody City city)
    {
        City newCity=cityRepository.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCity);
    }
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable long id)
    {
        Optional<City> cityOptional=cityRepository.findById(id);
        if(cityOptional.isPresent())
        {
            City presentCity=cityOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentCity);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable long id,@RequestBody City city)
    {
        Optional<City> cityOptional=cityRepository.findById(id);
        if(cityOptional.isPresent())
        {
            City cityPresent=cityOptional.get();
            cityPresent.setCityName(city.getCityName());
            cityPresent.setState(city.getState());
            cityRepository.save(cityPresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(cityPresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable long id)
    {
        Optional<City> cityOptional=cityRepository.findById(id);
        if(cityOptional.isPresent())
        {
            cityRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(cityOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/city/state/{id}")
    public Iterable<City> getCityByState(@PathVariable long id)
    {
        return cityRepository.getCityByState(id);
    }
}
