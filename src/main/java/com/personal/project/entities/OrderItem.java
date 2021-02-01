package com.personal.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.project.entities.pk.OrderItemPk;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor(onConstructor = @__(@Deprecated))
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product,Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    @JsonIgnore
    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @JsonIgnore
    public void setProduct(Product product) {
        id.setProduct(product);
    }
}
