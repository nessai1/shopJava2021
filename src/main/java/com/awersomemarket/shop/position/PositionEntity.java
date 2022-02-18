package com.awersomemarket.shop.position;

import com.awersomemarket.shop.orders.OrderEntity;
import com.awersomemarket.shop.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "s_position")
public class PositionEntity {
    @Setter(AccessLevel.NONE)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private ProductEntity product;

    @Setter(AccessLevel.PROTECTED)
    private Double count;
//
//    @Setter(AccessLevel.PROTECTED)
//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false)
//    private OrderEntity order;
}
