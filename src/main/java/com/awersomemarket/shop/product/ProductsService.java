package com.awersomemarket.shop.product;

import com.awersomemarket.shop.rest.dto.Products;

public interface ProductsService {

    Products getProducts();

    ProductEntity getProductById(Long id);
}
