package com.awersomemarket.shop.position;

import com.awersomemarket.shop.orders.OrderEntity;
import com.awersomemarket.shop.rest.dto.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    List<PositionEntity> getPositionEntitiesByOrder(OrderEntity order);
}
