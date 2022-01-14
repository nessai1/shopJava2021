package com.awersomemarket.shop.users;


import com.awersomemarket.shop.orders.OrderEntity;
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
@Table(name = "s_user")
public class UserEntity {
    @Setter(AccessLevel.NONE)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "phone", nullable = false, unique = true)
    @NaturalId(mutable = true)
    private String phone;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "age")
    private Integer age;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH, orphanRemoval = false)
    private List<OrderEntity> order;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
