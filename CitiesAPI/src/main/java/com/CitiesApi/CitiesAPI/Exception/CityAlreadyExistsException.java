package com.CitiesApi.CitiesAPI.Exception;

public class CityAlreadyExistsException extends RuntimeException {
    public CityAlreadyExistsException(String msg) {
        super(msg);
    }
}
