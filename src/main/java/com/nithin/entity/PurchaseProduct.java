package com.nithin.entity;

import com.nithin.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PurchaseProduct extends Product {

    private int noOfPieces;
    private double netPrice;
    private double finalPrice;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    @JoinColumn(name = "purchase_id") // Specify the name of the foreign key column
    private Purchase purchase;
}
