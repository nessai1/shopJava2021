package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.users.UserService;
import com.awersomemarket.shop.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserServiceImpl userService;
    private final OrderRepository orderRepository;

    @Autowired
    OrderServiceImpl(UserServiceImpl userService, OrderRepository orderRepository) {
        this.userService = userService;
        this.orderRepository = orderRepository;
    }


    @Override
    public void createOrder(Order order) {
    }
}
