package com.kevogaba.orderservice.command.api.aggregate;

import com.kevogaba.common.service.commands.CancelOrderCommand;
import com.kevogaba.common.service.commands.CompleteOrderCommand;
import com.kevogaba.common.service.events.OrderCancelledEvent;
import com.kevogaba.common.service.events.OrderCompletedEvent;
import com.kevogaba.orderservice.command.api.command.CreateOrderCommand;
import com.kevogaba.orderservice.command.api.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        //Validate the command
        OrderCreatedEvent orderCreatedEvent
                = new OrderCreatedEvent();

        BeanUtils.copyProperties(createOrderCommand,
                orderCreatedEvent);

        AggregateLifecycle.apply(orderCreatedEvent);
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderStatus = event.getOrderStatus();
        this.userId = event.getUserId();
        this.orderId = event.getOrderId();
        this.quantity = event.getQuantity();
        this.productId = event.getProductId();
        this.addressId = event.getAddressId();

    }

    @CommandHandler
    public void handle(CompleteOrderCommand completeOrderCommand) {
        //Validate the command
        //Publish OrderCompletedEvent
        OrderCompletedEvent orderCompletedEvent
                = OrderCompletedEvent
                .builder()
                .orderStatus(completeOrderCommand.getOrderStatus())
                .orderId(completeOrderCommand.getOrderId())
                .build();

        AggregateLifecycle.apply(orderCompletedEvent);
    }

    @EventSourcingHandler
    public void on(OrderCompletedEvent event) {
        this.orderStatus = event.getOrderStatus();
    }

    @CommandHandler
    public void handle(CancelOrderCommand cancelOrderCommand) {
        OrderCancelledEvent orderCancelledEvent
                = new OrderCancelledEvent();

        BeanUtils.copyProperties(cancelOrderCommand,
                orderCancelledEvent);

        AggregateLifecycle.apply(orderCancelledEvent);
    }

    @EventSourcingHandler
    public void on(OrderCancelledEvent event) {
        this.orderStatus = event.getOrderStatus();
    }
}
