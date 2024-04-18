package com.nithin.service.vendor;

import com.nithin.entity.vendor.Supplier;
import com.nithin.repository.VendorRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;
    @Override
    public Supplier saveVendorDetails(Supplier supplier) {
        Supplier supplier1=vendorRepository.save(supplier);
        return supplier1;
    }
}
