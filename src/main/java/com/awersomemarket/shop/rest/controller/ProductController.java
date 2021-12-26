package com.awersomemarket.shop.rest.controller;

import com.awersomemarket.shop.product.ProductsServiceImpl;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;
import com.awersomemarket.shop.exception.ProductNotFoundException;
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

//    public ProductController() {
//        Products productList = new Products();
//        Product product1 = new Product();
//        product1.setId(1L);
//        product1.setName("MacBook Pro");
//        product1.setPrice(new BigDecimal(344000));
//        product1.setWeight(new BigDecimal(3600));
//        product1.setImage("macbook-silver16.jpeg");
//
//        Product product2 = new Product();
//        product2.setId(2L);
//        product2.setName("iPhone pro 12");
//        product2.setPrice(new BigDecimal(79000));
//        product2.setWeight(new BigDecimal(700));
//        product2.setImage("macbook-silver16.jpeg");
//
//        List<Product> tmp = new ArrayList<Product>();
//        tmp.add(product1);
//        tmp.add(product2);
//
//        this.productList.setProductList(tmp);
//    }

    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Products products() {
        return this.productsService.getProducts();
    }

    @GetMapping(value = "product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product product(@PathVariable Long id) {
        this.q++;
        return this.productList.getProductList().stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with this id not found"));
    }

    @PostMapping(value = "/setproduct",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String setProductData(@RequestBody Product someProduct)
    {
        this.q += 100;
        return "Item added";
    }
}
