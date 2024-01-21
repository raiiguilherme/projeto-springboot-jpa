package com.aprendendo.aprendendospring.entities;

import java.io.Serializable;

import com.aprendendo.aprendendospring.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_order_item")
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class OrderItem implements Serializable {
    
    @EmbeddedId //id composto 
    private OrderItemPK id;
    private Integer quantity;
    private Double price;


    


    public OrderItem(Order order, Product product, OrderItemPK id, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    //getters e setter criados manualmente 
    public Order getOrder(){
        return id.getOrder(); //busca da classe OrderItemPK
    }
    public void setOrder(Order order){
        id.setOrder(order);
        
    }
    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product); 
        
    }
    //fim

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    

    
}
