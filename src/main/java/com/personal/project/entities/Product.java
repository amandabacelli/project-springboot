package com.personal.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_product")
@NoArgsConstructor(onConstructor = @__(@Deprecated))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product(String name, String description, Double price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        items.forEach(order -> set.add(order.getOrder()));
        return set;
    }
}
