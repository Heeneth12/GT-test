package com.nithin.entity;

import com.nithin.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PURCHASE")
@Data
public class Purchase {
    @Id
    private long purchaseId;

    private String vendorName;

    private Date purchaseData;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseProduct> productList;

    private double priceBeforeTaxes;

    private double priceAfterTaxes;

}
