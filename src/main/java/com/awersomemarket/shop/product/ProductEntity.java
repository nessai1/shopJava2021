package com.awersomemarket.shop.product;

import com.awersomemarket.shop.position.PositionEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "s_product")
public class ProductEntity {

    @Setter(AccessLevel.NONE)
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "PRICE", nullable = false, unique = false)
    private BigDecimal price;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "IMAGE", nullable = true, unique = false)
    private String image;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "AMOUNT", nullable = false, unique = false)
    private Double amount;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<PositionEntity> positions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
