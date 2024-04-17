package com.nithin.service.product;


import com.nithin.entity.product.Product;
import com.nithin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProductDetails(Product product) {
        Product existingProduct = productRepository.findByProductCode(product.getProductCode());
        if (existingProduct != null) {
            throw new RuntimeException("A product with the same product code already exists");
        }
        return productRepository.save(product);
    }

    @Override
    public Product findProduct(String productCode) {
        Product product=productRepository.findByProductCode(productCode);
        if (product==null) {
            throw new RuntimeException("Unable to find the product");
        }
        return product;
    }

    @Override
    public List<Product> listAllProducts() {
        List<Product> productList=productRepository.findAll();
        if(productList.isEmpty()||productList==null){
            throw new RuntimeException("No Products Available");
        }
        return productList;
    }

    @Override
    public void deleteProduct(String productCode) {
        Product product=productRepository.findByProductCode(productCode);
        if(product==null){
            throw new RuntimeException("Unable to find the product");
        }
        productRepository.deleteByProductCode(productCode);
    }

    @Override
    public Product updateProduct(Product tobeSavedProduct) {
        Product existingProduct = productRepository.findByProductCode(tobeSavedProduct.getProductCode());
        if (existingProduct == null) {
            throw new RuntimeException("Product not available with code: " + tobeSavedProduct.getProductCode());
        }
        existingProduct.setProductName(tobeSavedProduct.getProductName());
        existingProduct.setHsnCode(tobeSavedProduct.getHsnCode());
        existingProduct.setSGST(tobeSavedProduct.getSGST());
        existingProduct.setCGST(tobeSavedProduct.getCGST());
        existingProduct.setPrice(tobeSavedProduct.getPrice());
        existingProduct.setNoofPiecesCase(tobeSavedProduct.getNoofPiecesCase());
        existingProduct.setPiecePrice(tobeSavedProduct.getPiecePrice());
        return productRepository.save(existingProduct);
    }

}
