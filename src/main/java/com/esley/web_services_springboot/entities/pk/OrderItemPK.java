package com.esley.web_services_springboot.entities.pk;

import com.esley.web_services_springboot.entities.Order;
import com.esley.web_services_springboot.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable //Indica que essa classe pode ser embutida (incorporada) dentro de outra entidade do JPA/Hibernate, permitindo reutilizar atributos em uma única tabela do banco de dados
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinTable(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinTable(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
