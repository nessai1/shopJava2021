package com.awersomemarket.shop.users;

import com.awersomemarket.shop.rest.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer getUserByPhone(String phone) {
        List<UserEntity> user = userRepository.findUserEntityByPhone(phone);
        Customer c = new Customer();
        c.setPhone("123");
        c.setAddress("afafaf");
        c.setName("kekek");
        c.setId(1L);
        return c;
    }
}
