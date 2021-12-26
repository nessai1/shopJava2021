package com.awersomemarket.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByName(String name);
}
