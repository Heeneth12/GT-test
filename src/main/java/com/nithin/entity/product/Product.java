package com.nithin.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Product_Details")
public class Product {

    @Id
    private long productId;
    private String productCode;
    private String productName;
    private String hsnCode;
    private double sGST;
    private double cGST;
    private double price;
    private int noofPiecesCase;
    private double piecePrice;
}
