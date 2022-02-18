package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.position.PositionServiceImpl;
import com.awersomemarket.shop.product.ProductEntity;
import com.awersomemarket.shop.rest.dto.Customer;
import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.position.Position;
import com.awersomemarket.shop.users.UserEntity;
import com.awersomemarket.shop.users.UserService;
import com.awersomemarket.shop.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserServiceImpl userService;
    private final OrderRepository orderRepository;
    private final PositionServiceImpl positionService;

    @Autowired
    OrderServiceImpl(UserServiceImpl userService, OrderRepository orderRepository, PositionServiceImpl positionService) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.positionService = positionService;
    }


    @Override
    public void createOrder(Order order) {
        OrderEntity createdOrder = new OrderEntity();

        UserEntity orderUser = this.userService.createIfNotExits(order.getUser());
        createdOrder.setUser(orderUser);
        createdOrder.setAddress(order.getAddress());
        createdOrder.setStatus(OrderStatus.CREATED);
        createdOrder.setPositions(this.positionService.extractPositions(order.getPositionList()));
        this.orderRepository.saveAndFlush(createdOrder);
    }

//    protected List<ProductEntity> extractPositions(List<Position> products) {
//        List<ProductEntity>
//    }
}
