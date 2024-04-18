package com.nithin.mapper;

import com.nithin.Data.product.ProductDTO;
import com.nithin.Data.supplier.SupplierDTO;
import com.nithin.entity.product.Product;
import com.nithin.entity.vendor.Supplier;
import org.modelmapper.ModelMapper;

public class VendorMapper {
    public static final ModelMapper modelMapper=new ModelMapper();

    public static Supplier DTOtoEntity(SupplierDTO supplierDTO){
        return modelMapper.map(supplierDTO,Supplier.class);
    }
}
