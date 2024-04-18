package com.nithin.entity.vendor;


import com.nithin.entity.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SUPPLIER")
@Data
public class Supplier {
    @Id
    private long vendorId;
    private String vendorName;
    private String vendorType;
    private String vendorPhone;
    private String companyName;
    private Address address;
    private String gstNumber;


}
