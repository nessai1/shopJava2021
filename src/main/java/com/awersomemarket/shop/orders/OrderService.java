package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.rest.dto.Orders;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    Orders getOrders();
}
