package org.acme;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import java.util.Set;

@ConfigMapping(prefix = "rabbitmq")
public interface RabbitmqExchangeConfig {
    String url();
    String vhost();
    String username();
    String password();
    Exchanges exchanges();

    interface Exchanges {
        Set<Exchange> exchange();
    }

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

    default String getConfigDescription(){
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("url: ");
        stringBuffer.append(url()).append("\n");
        stringBuffer.append("vhost: ");
        stringBuffer.append(vhost()).append("\n");
        stringBuffer.append("user: ");
        stringBuffer.append(username()).append("\n");
        stringBuffer.append("pass: ");
        stringBuffer.append(password()).append("\n");
        stringBuffer.append("---------------").append("\n");

        exchanges().exchange().forEach(ex -> {
            stringBuffer.append("   ").append("name: ");
            stringBuffer.append("   ").append(ex.name()).append("\n");
            stringBuffer.append("   ").append("type: ");
            stringBuffer.append("   ").append(ex.type()).append("\n");
            stringBuffer.append("   ").append("autoDelete: ");
            stringBuffer.append("   ").append(ex.autoDelete()).append("\n");
            stringBuffer.append("   ").append("numberConsumers: ");
            stringBuffer.append("   ").append(ex.numberConsumers()).append("\n");
            stringBuffer.append("   ").append("numberRetries: ");
            stringBuffer.append("   ").append(ex.numberRetries()).append("\n");
            stringBuffer.append("   ").append("redeliveryDelay: ");
            stringBuffer.append("   ").append(ex.redeliveryDelay()).append("\n");
            stringBuffer.append("   ").append("maximumRedeliveries: ");
            stringBuffer.append("   ").append(ex.maximumRedeliveries()).append("\n");
            stringBuffer.append("---------------").append("\n");
        });

        return stringBuffer.toString();
    }
}
