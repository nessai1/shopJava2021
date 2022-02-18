package com.awersomemarket.shop.users;

import com.awersomemarket.shop.rest.dto.Customer;

public interface UserService {

    Customer getUserByPhone(String phone);
}
