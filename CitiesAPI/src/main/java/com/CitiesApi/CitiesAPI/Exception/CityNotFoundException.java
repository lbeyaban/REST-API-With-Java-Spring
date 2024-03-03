package com.CitiesApi.CitiesAPI.Exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String msg) {
        super(msg);
    }
}
