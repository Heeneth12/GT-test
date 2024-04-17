package com.nithin.transformer.product;

import com.nithin.Data.product.ProductDTO;
import com.nithin.entity.product.Product;
import com.nithin.mapper.ProductMapper;
import com.nithin.service.product.ProductServiceImpl;
import com.nithin.utility.FirmDetailsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTransformer {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductServiceImpl productService;

    public Product saveProductDetails(ProductDTO productDTO) {
        Product product=productMapper.DTOtoEntity(productDTO);
        Product product1=productService.saveProductDetails(product);

        return product1;
    }

    public Product findProduct(String productCode) {
        return productService.findProduct(productCode);
    }

    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    public void deleteProduct(String productCode) {
        productService.deleteProduct(productCode);
    }

    public Product updateProduct(ProductDTO productDTO) {
        Product product = productService.findProduct(productDTO.getProductCode());
        if (product == null) {
            throw new RuntimeException("Product not available with code: " + productDTO.getProductCode());
        }
        Product savedProduct = null;
        if (product != null) {
            Product tobeSavedProduct = productMapper.DTOtoEntity(productDTO);
            savedProduct = productService.updateProduct(tobeSavedProduct);
        }
        return savedProduct;
    }

}
