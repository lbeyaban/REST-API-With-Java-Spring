package com.CitiesApi.CitiesAPI.Service;

import com.CitiesApi.CitiesAPI.Exception.CityAlreadyExistsException;
import com.CitiesApi.CitiesAPI.Exception.CityNotFoundException;
import com.CitiesApi.CitiesAPI.Model.City;
import com.CitiesApi.CitiesAPI.Repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City createCity(City newCity) {
        Optional<City> cityByName = cityRepository.findByName(newCity.getCityName());
        if (cityByName.isPresent()) {
            throw new CityAlreadyExistsException("Il already exists with name: " + newCity.getCityName());
        }

        return cityRepository.save(newCity);

    }

    public City getCityByID(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City Not Found"));
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    private City getIlById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found with ID: " + id));
    }


    public void updateCity(String id, City newCity) {
        City oldCity = getIlById(id);
        oldCity.setCityName(newCity.getCityName());
        cityRepository.save(oldCity);
    }
}
