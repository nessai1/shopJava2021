package com.awersomemarket.shop.rest.controller;


import com.awersomemarket.shop.rest.dto.Customer;
import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.rest.dto.status.Status;
import com.awersomemarket.shop.rest.dto.status.StatusCode;
import com.awersomemarket.shop.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class OrderController {

    private final UserServiceImpl userService;

    @Autowired
    public OrderController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Status order(@RequestBody Order order)
    {
        System.out.println(12);
        Status st = new Status();
        st.setCode(StatusCode.OK);

        return st;
    }
}
