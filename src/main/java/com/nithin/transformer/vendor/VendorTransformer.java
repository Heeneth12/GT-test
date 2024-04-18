package com.nithin.transformer.vendor;

import com.nithin.Data.supplier.SupplierDTO;
import com.nithin.entity.vendor.Supplier;
import com.nithin.mapper.VendorMapper;
import com.nithin.service.vendor.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendorTransformer {

    @Autowired
    private VendorServiceImpl vendorService;

    public Supplier saveVendorDetails(SupplierDTO supplierDTO) {
        Supplier supplier=VendorMapper.DTOtoEntity(supplierDTO);
        vendorService.saveVendorDetails(supplier);
        return supplier;
    }
}
