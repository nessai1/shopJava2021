package com.awersomemarket.shop.rest.controller;

import com.awersomemarket.shop.exception.ProductHavePositionsException;
import com.awersomemarket.shop.product.ProductsServiceImpl;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;
import com.awersomemarket.shop.rest.dto.status.Status;
import com.awersomemarket.shop.rest.dto.status.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/admin")
public class RestAdminController {

    private final ProductsServiceImpl productsService;

    @Autowired
    RestAdminController(ProductsServiceImpl productsService) {
        this.productsService = productsService;
    }

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Status changeProduct(@RequestBody Product product) {
        if (product.getId() == null) {
            this.productsService.createProduct(product);
        }
        else {
            this.productsService.changeProduct(product);
        }

        Status st = new Status();
        st.setCode(StatusCode.OK);
        return st;
    }

    @DeleteMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Status deleteProduct(@RequestBody Product product) throws ProductHavePositionsException {
        Status st = new Status();

        try {
            this.productsService.deleteProduct(product);
            st.setCode(StatusCode.OK);
        }
        catch (ProductHavePositionsException e) {
            st.setCode(StatusCode.POSITIONS_EXIST);
            st.setErrorDescription("Данный товар присутствует в существющих заказах");
        }
        catch (Exception e) {
            st.setCode(StatusCode.UNHANDLED_ERROR);
            st.setErrorDescription("Произошла непредвиденная ошибка");
        }

        return st;
    }

//    @PutMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Status changeProduct(@RequestBody Product product) {
//        Status st = new Status();
//
//        try {
//            this.productsService.deleteProduct(product);
//            st.setCode(StatusCode.OK);
//        }
//        catch (ProductHavePositionsException e) {
//            st.setCode(StatusCode.POSITIONS_EXIST);
//            st.setErrorDescription("Данный товар присутствует в существющих заказах");
//        }
//        catch (Exception e) {
//            st.setCode(StatusCode.UNHANDLED_ERROR);
//            st.setErrorDescription("Произошла непредвиденная ошибка");
//        }
//
//        return st;
//    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Products products() {
        return this.productsService.getProducts();
    }
}