package com.CitiesApi.CitiesAPI.Controller;

import com.CitiesApi.CitiesAPI.Exception.CityAlreadyExistsException;
import com.CitiesApi.CitiesAPI.Exception.CityNotFoundException;
import com.CitiesApi.CitiesAPI.Model.City;
import com.CitiesApi.CitiesAPI.Service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> GetCities(@RequestParam(required = false) String name){
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> GetCity(@PathVariable String id) {
        return new ResponseEntity<>(cityService.getCityByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> CreateCity(@RequestBody City newCity) {
        return new ResponseEntity<>(cityService.createCity(newCity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteCity(@PathVariable String id){
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> UpdateCity(@PathVariable String id, @RequestBody City newCity) {
        cityService.updateCity(id, newCity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> handleCityNotFoundException(CityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityAlreadyExistsException.class)
    public ResponseEntity<String> handleIlCityAlreadyExistsException(CityAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }



}
