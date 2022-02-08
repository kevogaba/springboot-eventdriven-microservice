package com.kevogaba.orderservice.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private String quantity;
    private String orderStatus;
}
