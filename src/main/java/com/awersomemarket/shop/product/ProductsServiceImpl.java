package com.awersomemarket.shop.product;

import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;

    @Autowired
    ProductsServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Products getProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> productList = productEntityList.stream().map(c -> {
            Product product = new Product();
            product.setId(c.getId());
            product.setPrice(c.getPrice());
            product.setName(c.getName());
            product.setImage(c.getImage());
            product.setWeight(c.getWeight());
            return product;
        }).collect(Collectors.toList());

        Products products = new Products();
        products.setProductList(productList);
        return products;
    }
}
