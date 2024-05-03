package com.example.tzrstech.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(schema = "bi2", name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotEmpty(message = "Product name can't be empty.")
    @Size(min = 2, max = 128, message = "Product name must be between 2 and 128 characters.")
    @Column(name = "product_name")
    private String productName;

    @Size(min = 2, max = 128, message = "Product description must be between 2 and 128 characters.")
    @Column(name = "description")
    private String description;

    @Positive(message = "Product price can't be smaller than 0")
    @Column(name = "price")
    private Integer price;

    @CreationTimestamp
    @Column(name = "appearence_date")
    private Date appearenceDate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "category_id")
    private Category category;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Product product = (Product) o;
        return getProductId() != null && Objects.equals(getProductId(), product.getProductId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
