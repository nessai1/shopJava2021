package com.awersomemarket.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByName(String name);
}
