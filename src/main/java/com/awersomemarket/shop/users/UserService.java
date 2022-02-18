package com.awersomemarket.shop.users;

import com.awersomemarket.shop.rest.dto.Customer;

public interface UserService {

    Customer findByPhone(String phone);

    UserEntity createIfNotExits(Customer user);

    void createUser(Customer user);
}
