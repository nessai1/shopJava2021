package com.awersomemarket.shop.users;

import com.awersomemarket.shop.exception.UserPhoneExistsException;
import com.awersomemarket.shop.orders.OrderEntity;
import com.awersomemarket.shop.rest.dto.Customer;
import com.awersomemarket.shop.rest.dto.Order;
import org.apache.catalina.User;
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

    @Override
    public Customer findByPhone(String phone) {

        Customer user = new Customer();
        user.setId(0L);
        if (userRepository.existsByPhone(phone)) {
            UserEntity findUser = userRepository.getByPhone(phone);
            user.setId(findUser.getId());
            user.setPhone(findUser.getPhone());
            user.setName(findUser.getName());
        }

        return user;
    }

    @Override
    public UserEntity createIfNotExits(Customer user) {
        if (!userRepository.existsByPhone(user.getPhone())) {
            this.createUser(user);
        }

        return userRepository.getByPhone(user.getPhone());
    }


    @Override
    public void createUser(Customer user) {

        boolean existedUsers = userRepository.existsByPhone(user.getPhone());
        if (existedUsers) {
            throw new UserPhoneExistsException("User with enter phone already exists");
        }
        else {
            UserEntity createdUser = new UserEntity();
            createdUser.setName(user.getName());
            createdUser.setPhone(user.getPhone());

            userRepository.saveAndFlush(createdUser);
        }
    }
}
