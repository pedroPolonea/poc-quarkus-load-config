package org.acme.ex01;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class RabbitmqExchangeConfigTest {

    @Inject
    private RabbitmqExchangeConfig rabbitmqExchangeConfig;

    @Test
    void shouldNameConfig() {
        assertEquals("order", rabbitmqExchangeConfig.exchanges()
                .exchange()
                .stream()
                .filter(exchange -> exchange.name().equalsIgnoreCase("order"))
                .findFirst()
                .get()
                .name()
        );

        assertEquals("order2", rabbitmqExchangeConfig.exchanges()
                .exchange()
                .stream()
                .filter(exchange -> exchange.name().equalsIgnoreCase("order2"))
                .findFirst()
                .get()
                .name()
        );

    }
}