package com.nithin.Data.product;

import lombok.Data;

import java.io.Serializable;


public class ProductDTO {
    private String productCode;
    private String productName;
    private String hsnCode;
    private double sGST;
    private double cGST;
    private double price;
    private int noofPiecesCase;
    private double piecePrice;

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
