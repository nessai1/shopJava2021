package com.awersomemarket.shop.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByPhone(String phone);

    UserEntity getByPhone(String phone);
}
