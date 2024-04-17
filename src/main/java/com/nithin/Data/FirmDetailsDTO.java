package com.nithin.Data;

import com.nithin.entity.Address;
import com.nithin.entity.FirmDetails;
import jakarta.persistence.Embedded;
import lombok.Data;


@Data
public class FirmDetailsDTO {

    private long firmId;
    private String firmName;
    private String phoneNumber;
    private Address address;


}
