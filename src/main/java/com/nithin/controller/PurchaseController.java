package com.nithin.controller;

import com.nithin.Data.PurchaseDTO;
import com.nithin.entity.Purchase;
import com.nithin.generic.Success;
import com.nithin.transformer.purchase.PurchaseTransfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseTransfomer purchaseTransfomer;

    @PostMapping("/create")
    public ResponseEntity<Object> purchaseReceipt(@RequestBody PurchaseDTO purchaseDTO){
        try {
            Purchase purchase= purchaseTransfomer.createPurchaseRecord(purchaseDTO);
                Success success = createSuccessResponse("Purchase Saved Successfully", HttpStatus.CREATED);
                return new ResponseEntity<>(success, HttpStatus.CREATED);
        }catch (RuntimeException e) {
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
