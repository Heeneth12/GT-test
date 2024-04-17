package com.nithin.controller;

import com.nithin.Data.product.ProductDTO;
import com.nithin.entity.product.Product;
import com.nithin.generic.Success;
import com.nithin.transformer.product.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductTransformer productTransformer;

    @PostMapping("/create-product")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            Product product = productTransformer.saveProductDetails(productDTO);
            Success success = createSuccessResponse("Product Saved Successfully", HttpStatus.CREATED);
            return new ResponseEntity<>(success, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productCode}")
    public ResponseEntity<Object> getListOfProducts(@PathVariable String productCode){
        try{
            Product product=productTransformer.findProduct(productCode);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list-products")
    public ResponseEntity<Object> getListOfProducts(){
        try{
            List<Product> productList=productTransformer.listAllProducts();
            return new ResponseEntity<>(productList,HttpStatus.OK);
        }catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-product")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            Product product = productTransformer.updateProduct(productDTO);
            Success success = createSuccessResponse("Product updated Successfully", HttpStatus.CREATED);
            return new ResponseEntity<>(success, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{productCode}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String productCode){
        try{
            productTransformer.deleteProduct(productCode);
            Success success = createSuccessResponse("Product deleted Successfully" +productCode, HttpStatus.CREATED);
            return new ResponseEntity<>(success,HttpStatus.OK);
        }catch (RuntimeException e) {
            return handleException(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private ResponseEntity<Object> handleException(Exception e, HttpStatus status) {
        Success success = new Success();
        success.setMessage( e.getMessage());
        success.setStatusCode(status.toString());
        return new ResponseEntity<>(success, status);
    }

    private Success createSuccessResponse(String message, HttpStatus status) {
        Success success = new Success();
        success.setMessage(message);
        success.setStatusCode(status.toString());
        return success;
    }



}
