package com.nithin.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FIRM_DETAILS")
public class FirmDetails {
    @Id
    private long firmId;
    private String firmName;
    private String phoneNumber;
    @Embedded
    private Address address;
}
