package com.personal.project.entities;

import com.personal.project.entities.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
@NoArgsConstructor(onConstructor = @__(@Deprecated))
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime moment;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //vai ter o mesmo id )
    private Payment payment;

    public Order(OrderStatus orderStatus, User client) {
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        double sum = 0.0;
        for(OrderItem i : items){
            sum += i.getSubTotal();
        }
        return sum;
    }
}
