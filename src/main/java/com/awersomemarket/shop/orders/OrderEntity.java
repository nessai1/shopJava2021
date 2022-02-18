package com.awersomemarket.shop.orders;

import com.awersomemarket.shop.position.PositionEntity;
import com.awersomemarket.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
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
    @Column(name = "STATUS", nullable = false, unique = false)
    private OrderStatus status;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "ADDRESS", nullable = false, unique = false)
    private String address;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private List<PositionEntity> positions;

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
