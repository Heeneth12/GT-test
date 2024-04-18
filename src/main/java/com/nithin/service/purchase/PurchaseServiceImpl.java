package com.nithin.service.purchase;

import com.nithin.entity.Purchase;
import com.nithin.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Override
    public Purchase saveThePurchase(Purchase purchase) {
        System.out.println("Saving purchase...");
        Purchase savedPurchase = purchaseRepository.save(purchase);
        System.out.println("Purchase saved successfully with ID: " + savedPurchase.getPurchaseId());
        return savedPurchase;
    }
}
