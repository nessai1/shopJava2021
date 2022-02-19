package com.awersomemarket.shop.product;

import com.awersomemarket.shop.exception.ProductHavePositionsException;
import com.awersomemarket.shop.position.PositionEntity;
import com.awersomemarket.shop.position.PositionRepository;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;
    private final PositionRepository positionRepository;

    @Autowired
    ProductsServiceImpl(ProductRepository productRepository, PositionRepository positionRepository)
    {
        this.positionRepository = positionRepository;
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
            product.setAmount(c.getAmount());
            return product;
        }).collect(Collectors.toList());

        Products products = new Products();
        products.setProductList(productList);
        return products;
    }

    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setAmount(product.getAmount());
        productEntity.setName(product.getName());
        if (product.getImage() == null) {
            productEntity.setImage("default.jpg");
        }
        else {
            productEntity.setImage(product.getImage());
        }
        productEntity.setPrice(product.getPrice());

        productRepository.saveAndFlush(productEntity);

        product.setId(productEntity.getId());
        product.setImage(productEntity.getImage());

        return product;
    }

    public void deleteProduct(Product product) throws ProductHavePositionsException {

        /// HARDCODEEE LETSGOOOOOO!!!!
        ProductEntity productEntity = productRepository.getProductEntityById(product.getId());
        List<PositionEntity> positions = positionRepository.getPositionEntitiesByProduct(productEntity);
        if (positions.size() > 0) {
            throw new ProductHavePositionsException("У данного товара есть существующие позиции");
        }

        productRepository.delete(productEntity);
    }

    public Product changeProduct(Product product) {
        ProductEntity productEntity = productRepository.getProductEntityById(product.getId());
        productEntity.setPrice(product.getPrice());
        productEntity.setAmount(product.getAmount());
        if (product.getImage() != null)
        {
            productEntity.setImage(product.getImage());
        }
        productEntity.setName(product.getName());

        productRepository.saveAndFlush(productEntity);
        return product;
    }

    public ProductEntity getProductById(Long id) {
        return this.productRepository.getProductEntityById(id);
    }
}
