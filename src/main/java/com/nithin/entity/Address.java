package com.nithin.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String doorNumber;
    private String streetAddress1;
    private String streetAddress2;
    private String cityName;
    private String pinCode;
    private String stateName;
    private String countryName;
}
