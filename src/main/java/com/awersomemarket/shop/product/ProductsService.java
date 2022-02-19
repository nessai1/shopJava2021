package com.awersomemarket.shop.product;

import com.awersomemarket.shop.exception.ProductHavePositionsException;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;

public interface ProductsService {

    Products getProducts();

    ProductEntity getProductById(Long id);

    Product createProduct(Product product);

    Product changeProduct(Product product);

    void deleteProduct(Product product) throws ProductHavePositionsException;
}
