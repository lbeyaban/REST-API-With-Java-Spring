package com.CitiesApi.CitiesAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    private String CityID;

    private String CityName;

    private Date CreatedDate = new Date();
}
