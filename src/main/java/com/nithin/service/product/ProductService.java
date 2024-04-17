package com.nithin.service.product;

import com.nithin.entity.product.Product;

import java.util.List;

public interface ProductService {
    Product saveProductDetails(Product product);

    Product findProduct(String productCode);

    List<Product> listAllProducts();


    void deleteProduct(String productCode);

    Product updateProduct(Product tobeSavedProduct);
}
