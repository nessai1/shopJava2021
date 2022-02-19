package com.awersomemarket.shop.rest.controller;

import com.awersomemarket.shop.product.ProductsServiceImpl;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;
import com.awersomemarket.shop.exception.ProductNotFoundException;
import com.awersomemarket.shop.rest.dto.status.Status;
import com.awersomemarket.shop.rest.dto.status.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
//@RequestMapping("w1/cakes")
public class ProductController {

    private int q = 0;
    private final Products productList = new Products();
    private final ProductsServiceImpl productsService;

    @Autowired
    public ProductController(ProductsServiceImpl productsService) {
        this.productsService = productsService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Products products() {
        return this.productsService.getProducts();
    }


//    @GetMapping(value = "product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Product product(@PathVariable Long id) {
//        this.q++;
//        return this.productList.getProductList().stream()
//                .filter(el -> el.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new ProductNotFoundException("Product with this id not found"));
//    }
//
//    @PostMapping(value = "/setproduct",
//    consumes = MediaType.APPLICATION_JSON_VALUE,
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    public String setProductData(@RequestBody Product someProduct)
//    {
//        this.q += 100;
//        return "Item added";
//    }
}
