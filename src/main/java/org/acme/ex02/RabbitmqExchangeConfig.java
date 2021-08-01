package org.acme.ex02;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithParentName;

import java.util.Map;
import java.util.Set;

@ConfigMapping(prefix = "rabbitmq-02")
public interface RabbitmqExchangeConfig {
    String url();
    String vhost();
    String username();
    String password();

    @WithParentName
    Map<String, Exchange> exchange();

    interface Exchange {
        String name();
        String type();
        @WithDefault("false")
        boolean autoDelete();
        @WithDefault("3")
        int numberConsumers();
        @WithDefault("3")
        int numberRetries();
        @WithDefault("3000")
        int redeliveryDelay();
        @WithDefault("-1")
        int maximumRedeliveries();

    }

}
