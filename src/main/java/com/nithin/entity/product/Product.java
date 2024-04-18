package com.nithin.entity.product;

import com.nithin.entity.Purchase;
import jakarta.persistence.*;
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



    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public double getsGST() {
        return sGST;
    }

    public void setsGST(double sGST) {
        this.sGST = sGST;
    }

    public double getcGST() {
        return cGST;
    }

    public void setcGST(double cGST) {
        this.cGST = cGST;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoofPiecesCase() {
        return noofPiecesCase;
    }

    public void setNoofPiecesCase(int noofPiecesCase) {
        this.noofPiecesCase = noofPiecesCase;
    }

    public double getPiecePrice() {
        return piecePrice;
    }

    public void setPiecePrice(double piecePrice) {
        this.piecePrice = piecePrice;
    }
}
