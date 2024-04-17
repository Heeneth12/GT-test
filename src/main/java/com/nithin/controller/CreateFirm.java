package com.nithin.controller;


import com.nithin.Data.FirmDetailsDTO;
import com.nithin.entity.FirmDetails;
import com.nithin.generic.Success;
import com.nithin.transformer.FirmDetailsTransformer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateFirm {

    @Autowired
    private FirmDetailsTransformer firmDetailsTransformer;

    @PostMapping("/create-firm")
    public ResponseEntity<Object> createFirmName(@RequestBody FirmDetailsDTO firmDetailsDTO){
        FirmDetails createdFirmDetails= firmDetailsTransformer.creteFirmDetails(firmDetailsDTO);
        if(createdFirmDetails!=null){
            Success success= new Success();
            success.setMessage("FirmDetails Created Successfully");
            success.setStatusCode(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(success,HttpStatus.CREATED);
        }else{
            Success errorResponse= new Success();
            errorResponse.setMessage("Failed to Create Firm Details");
            errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/firmname/{id}")
    public ResponseEntity<Object> getFirmName(@PathVariable String id){
         FirmDetailsDTO retrievedFirmDetails=firmDetailsTransformer.getFirmDetails(id);
        return new ResponseEntity<>(retrievedFirmDetails,HttpStatus.OK);
    }

}
