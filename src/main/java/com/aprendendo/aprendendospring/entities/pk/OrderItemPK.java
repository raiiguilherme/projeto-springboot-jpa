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
@Embeddable //relacionamento composto
public class OrderItemPK implements Serializable {

    @ManyToOne //tipo de relacionamento 
    @JoinColumn (name = "id_order") //campo da tabela
    private Order order;

    @ManyToOne //tipo de relacionamento 
    @JoinColumn(name="id_product") //campo da tabela
    private Product product;


}
