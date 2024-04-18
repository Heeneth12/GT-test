package com.nithin.mapper;

import com.nithin.Data.product.ProductDTO;
import com.nithin.entity.product.Product;
import com.nithin.utility.FirmDetailsUtility;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product DTOtoEntity(ProductDTO productDTO){
        Product product= new Product();
        product.setProductId(FirmDetailsUtility.generateFirmId());
        product.setProductCode(productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        product.setHsnCode(productDTO.getHsnCode());
        product.setPrice(productDTO.getPrice());
        product.setcGST(productDTO.getcGST());
        product.setsGST(productDTO.getsGST());
        product.setPiecePrice(productDTO.getPiecePrice());
        product.setNoofPiecesCase(productDTO.getNoofPiecesCase());
        return product;
    }
}
