package com.nithin.Data;

import com.nithin.entity.Purchase;

public class PurchaseProductDTO {
    private Purchase purchase;
    private int noOfPieces;
    private double netPrice;
    private double finalPrice;

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public void setNoOfPieces(int noOfPieces) {
        this.noOfPieces = noOfPieces;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
