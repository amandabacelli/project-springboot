package com.personal.project.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED;

    public static OrderStatus value(final String name) {
        try {
            return OrderStatus.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new EnumConstantNotPresentException(OrderStatus.class, name);
        }
    }

}
