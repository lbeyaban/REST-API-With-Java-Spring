package com.CitiesApi.CitiesAPI.Repository;

import com.CitiesApi.CitiesAPI.Model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
