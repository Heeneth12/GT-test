package com.nithin.transformer.purchase;

import com.nithin.Data.PurchaseDTO;
import com.nithin.entity.Purchase;
import com.nithin.entity.PurchaseProduct;
import com.nithin.service.purchase.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PurchaseTransfomer {

    @Autowired
    private PurchaseServiceImpl purchaseService;


    public Purchase createPurchaseRecord(PurchaseDTO purchaseDTO) {
        Purchase purchase=new Purchase();
//        PurchaseProduct purchaseProduct = new PurchaseProduct();
//        purchaseProduct.setp
        purchase.setPurchaseId(purchaseDTO.getPurchaseId());
        purchase.setPurchaseData(new Date());
        purchase.setVendorName(purchaseDTO.getVendorName());
        purchase.setProductList(purchaseDTO.getProductList());


        purchase.setPriceBeforeTaxes(purchaseDTO.getPriceBeforeTaxes());
        purchase.setPriceAfterTaxes(purchaseDTO.getPriceAfterTaxes());
        return purchaseService.saveThePurchase(purchase);
    }


}
