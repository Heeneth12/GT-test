package com.nithin.controller;

import com.nithin.Data.supplier.SupplierDTO;
import com.nithin.entity.vendor.Supplier;
import com.nithin.generic.Success;
import com.nithin.transformer.vendor.VendorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorTransformer vendorTransformer;


    @PostMapping("/create")
    public ResponseEntity<Object> createVendor(@RequestBody SupplierDTO supplierDTO){
        try {
            Supplier supplier = vendorTransformer.saveVendorDetails(supplierDTO);
            Success success = createSuccessResponse("Vendor created Successfully", HttpStatus.CREATED);
            return new ResponseEntity<>(success, HttpStatus.CREATED);
        }
        catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<Object> handleException(Exception e, HttpStatus status) {
        Success success = new Success();
        success.setMessage( e.getMessage());
        success.setStatusCode(status.toString());
        return new ResponseEntity<>(success, status);
    }

    private Success createSuccessResponse(String message, HttpStatus status) {
        Success success = new Success();
        success.setMessage(message);
        success.setStatusCode(status.toString());
        return success;
    }

}
