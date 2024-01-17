package com.anytimedeveloper.akprojects.studentStack.controllers;

import com.anytimedeveloper.akprojects.studentStack.pojos.Country;
import com.anytimedeveloper.akprojects.studentStack.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @GetMapping("/countries")
    public Iterable<Country> getAllCountries()
    {
        return countryRepository.findAll();
    }
    @PostMapping("/countries")
    public ResponseEntity<Country> addCountry(@RequestBody Country country)
    {
        Country newCountry=countryRepository.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
    }
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable long id)
    {
        Optional<Country> countryOptional=countryRepository.findById(id);
        if(countryOptional.isPresent())
        {
            Country presentCountry=countryOptional.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(presentCountry);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id,@RequestBody Country country)
    {
        Optional<Country> countryOptional=countryRepository.findById(id);
        if(countryOptional.isPresent())
        {
            Country countryPresent=countryOptional.get();
            countryPresent.setCountryName(country.getCountryName());
            countryRepository.save(countryPresent);
            return ResponseEntity.status(HttpStatus.CREATED).body(countryPresent);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable long id)
    {
        Optional<Country> countryOptional=countryRepository.findById(id);
        if(countryOptional.isPresent())
        {
            countryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(countryOptional.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
