package com.esley.web_services_springboot.entities.enums;

public enum OrderStatus {

    WHATING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code; // Código do tipo enumerado
    OrderStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    // Método do tipo estático para converter um valor númerico para um tipo enumerado
    // estático pq esse metódo vai funcionar sem precisar instanciar

    public static OrderStatus valueof(int code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getCode() == code) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("OrderStatus code " + code + " not found");
    }
}
