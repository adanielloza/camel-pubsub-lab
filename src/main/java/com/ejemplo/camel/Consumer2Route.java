package com.ejemplo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Consumer2Route extends RouteBuilder {
    @Override
    public void configure() {
        from("rabbitmq://localhost/alert-exchange"
            + "?queue=email.consumer.queue"
            + "&exchangeType=fanout"
            + "&autoDelete=false"
            + "&username=guest"
            + "&password=guest")
        .log("✉️ [Consumer 2] Simulando envío por email: ${body}");
    }
}