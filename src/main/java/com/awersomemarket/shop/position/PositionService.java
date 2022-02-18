package com.awersomemarket.shop.position;

import com.awersomemarket.shop.orders.OrderEntity;
import com.awersomemarket.shop.rest.dto.position.Position;

import java.util.List;

public interface PositionService {

    List<PositionEntity> extractPositions(List<Position> positions);
}
