package com.aprendendo.aprendendospring.entities.pk;

import java.io.Serializable;

import com.aprendendo.aprendendospring.entities.Order;
import com.aprendendo.aprendendospring.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn (name = "id_order")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;


}
