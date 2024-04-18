package com.nithin.Data;

import com.nithin.entity.PurchaseProduct;

import java.util.Date;
import java.util.List;

public class PurchaseDTO {

    private long purchaseId;

    private String vendorName;

    private Date purchaseData;

    private List<PurchaseProduct> productList;

    private double priceBeforeTaxes;

    private double priceAfterTaxes;

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Date getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(Date purchaseData) {
        this.purchaseData = purchaseData;
    }

    public List<PurchaseProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<PurchaseProduct> productList) {
        this.productList = productList;
    }

    public double getPriceBeforeTaxes() {
        return priceBeforeTaxes;
    }

    public void setPriceBeforeTaxes(double priceBeforeTaxes) {
        this.priceBeforeTaxes = priceBeforeTaxes;
    }

    public double getPriceAfterTaxes() {
        return priceAfterTaxes;
    }

    public void setPriceAfterTaxes(double priceAfterTaxes) {
        this.priceAfterTaxes = priceAfterTaxes;
    }
}
