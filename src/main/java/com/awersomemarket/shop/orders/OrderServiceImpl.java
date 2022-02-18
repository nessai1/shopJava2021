package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;

    @Autowired
    OrderServiceImpl(UserService userService, OrderRepository orderRepository) {
        this.userService = userService;
        this.orderRepository = orderRepository;
    }


    @Override
    public void createOrder(Order order) {

    }
}
