package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.exception.IncorrectOrderStatusChangeException;
import com.awersomemarket.shop.position.PositionEntity;
import com.awersomemarket.shop.position.PositionServiceImpl;
import com.awersomemarket.shop.product.ProductEntity;
import com.awersomemarket.shop.rest.dto.Customer;
import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.rest.dto.Orders;
import com.awersomemarket.shop.rest.dto.Product;
import com.awersomemarket.shop.rest.dto.position.Position;
import com.awersomemarket.shop.users.UserEntity;
import com.awersomemarket.shop.users.UserService;
import com.awersomemarket.shop.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Orders getOrders() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<Order> orderList = orderEntityList.stream().map(c -> {
            Order order = new Order();
            order.setId(c.getId());
            order.setAddress(c.getAddress());
            order.setOrderStatus(c.getStatus());

            Customer orderCustomer = new Customer();
            orderCustomer.setName(c.getUser().getName());
            orderCustomer.setPhone(c.getUser().getPhone());
            orderCustomer.setId(c.getUser().getId());
            order.setUser(orderCustomer);

            List<PositionEntity> positionEntities = c.getPositions();
            List<Position> positions = positionEntities.stream().map(p -> {
                Position position = new Position();
                position.setCount(p.getCount());
                position.setId(p.getProduct().getId());

                return position;
            }).collect(Collectors.toList());

            order.setPositionList(positions);

            return order;
        }).collect(Collectors.toList());

        Orders orders = new Orders();
        orders.setOrderList(orderList);
        return orders;
    }

    @Override
    public void changeOrderStatus(Order order) throws IncorrectOrderStatusChangeException {
        OrderEntity orderEntity = this.orderRepository.getById(order.getId());

        if (!checkStatusMigration(orderEntity.getStatus(), order.getOrderStatus())) {
            throw new IncorrectOrderStatusChangeException("Переход на указанный статус невозможен");
        }

        orderEntity.setStatus(order.getOrderStatus());
        orderRepository.saveAndFlush(orderEntity);
    }

    protected boolean checkStatusMigration(OrderStatus before, OrderStatus after) {
        return true;
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
