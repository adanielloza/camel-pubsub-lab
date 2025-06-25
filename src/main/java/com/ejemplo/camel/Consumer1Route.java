package com.ejemplo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Consumer1Route extends RouteBuilder {
    @Override
    public void configure() {
        from("rabbitmq:localhost/alert-exchange"
            + "?queue=console.consumer.queue"
            + "&exchangeType=fanout"
            + "&autoDelete=false"
            + "&username=guest"
            + "&password=guest")
        .log("✅ [Consumer 1] Mensaje recibido: ${body}");
    }
}
