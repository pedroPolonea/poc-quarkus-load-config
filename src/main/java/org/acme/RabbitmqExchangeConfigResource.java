package org.acme;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/")
public class RabbitmqExchangeConfigResource {
    private static final Logger LOG = Logger.getLogger(RabbitmqExchangeConfigResource.class);

    @Inject
    private RabbitmqExchangeConfig rabbitmqExchangeConfig;

    @Inject
    public RabbitmqExchangeConfigResource(final RabbitmqExchangeConfig rabbitmqExchangeConfig) {
        this.rabbitmqExchangeConfig = rabbitmqExchangeConfig;
    }

    @GET
    public String getConfig() {
        return rabbitmqExchangeConfig.getConfigDescription();
    }
}

