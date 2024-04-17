package com.nithin.Data;

import lombok.Data;


@Data
public class AddressDTO {

    private String doorNumber;
    private String streetAddress1;
    private String streetAddress2;
    private String cityName;
    private String pinCode;
    private String stateName;
    private String countryName;
}
