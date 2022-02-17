package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "s_order")
public class OrderEntity {

    @Setter(AccessLevel.NONE)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntity user;

    @Setter(AccessLevel.PROTECTED)
    private OrderStatus status;

    @Setter(AccessLevel.PROTECTED)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
