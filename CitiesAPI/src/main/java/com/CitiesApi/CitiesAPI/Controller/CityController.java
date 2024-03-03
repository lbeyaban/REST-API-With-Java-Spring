package com.CitiesApi.CitiesAPI.Controller;

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
    public ResponseEntity<List<City>> GetCities(){
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

}
