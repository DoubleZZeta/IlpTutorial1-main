package uk.ac.ed.acp.cw2.configuration;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HeathIndicator extends AbstractHealthIndicator
{
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception
    {
        builder.up();
    }
}
