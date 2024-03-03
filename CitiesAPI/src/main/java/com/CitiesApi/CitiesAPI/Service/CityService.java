package com.CitiesApi.CitiesAPI.Service;

import com.CitiesApi.CitiesAPI.Model.City;
import com.CitiesApi.CitiesAPI.Repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    public List<City> getCities() {
        return cityRepository.findAll();
    }


    public City createCity(City newCity) {
        return cityRepository.insert(newCity);
    }

    public City getCityByID(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City Not Found"));
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }
}
