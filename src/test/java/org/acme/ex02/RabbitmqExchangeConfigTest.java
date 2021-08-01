package org.acme.ex02;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
class RabbitmqExchangeConfigTest {

    @Inject
    private RabbitmqExchangeConfig rabbitmqExchangeConfig;

    @Test
    void shouldNameConfig() {
        assertEquals("order", rabbitmqExchangeConfig.exchange()
                .get("exchange-01-key")
                .name()
        );

        assertEquals("order2", rabbitmqExchangeConfig.exchange()
                .get("exchange-02-key")
                .name()
        );
    }
}