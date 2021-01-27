package com.personal.project.repositories;

import com.personal.project.entities.OrderItem;
import com.personal.project.entities.User;
import com.personal.project.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
