package com.awersomemarket.shop.position;

import com.awersomemarket.shop.orders.OrderEntity;
import com.awersomemarket.shop.product.ProductEntity;
import com.awersomemarket.shop.product.ProductsServiceImpl;
import com.awersomemarket.shop.rest.dto.position.Position;
import com.awersomemarket.shop.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private final ProductsServiceImpl productsService;
    private final PositionRepository positionRepository;

    @Autowired
    PositionServiceImpl(PositionRepository positionRepository, ProductsServiceImpl productsService) {
        this.productsService = productsService;
        this.positionRepository = positionRepository;
    }



    @Override
    public List<PositionEntity> extractPositions(List<Position> positions) {
        List<PositionEntity> entityList = positions.stream().map(position -> {
            PositionEntity entity = new PositionEntity();
            entity.setCount(position.getCount());
            ProductEntity product = productsService.getProductById(position.getId());
            entity.setProduct(product);
            return entity;
        }).collect(Collectors.toList());

        return entityList;
    }

    @Override
    public List<PositionEntity> getPositionsByProduct(ProductEntity productEntity) {
        return this.positionRepository.getPositionEntitiesByProduct(productEntity);
    }
}
