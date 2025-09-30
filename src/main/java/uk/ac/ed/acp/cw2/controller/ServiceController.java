package uk.ac.ed.acp.cw2.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import uk.ac.ed.acp.cw2.configuration.Position;
import uk.ac.ed.acp.cw2.data.RuntimeEnvironment;
import uk.ac.ed.acp.cw2.configuration.HeathIndicator;


import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;
import java.time.Instant;

/**
 * Controller class that handles various HTTP endpoints for the application.
 * Provides functionality for serving the index page, retrieving a static UUID,
 * and managing key-value pairs through POST requests.
 */
@RestController()
@RequestMapping("/api/v1")
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Value("${ilp.service.url}")
    public URL serviceUrl;

    @GetMapping("/")
    public String index() {
        return "<html><body>" +
                "<h1>Welcome from ILP</h1>" +
                "<h4>ILP-REST-Service-URL:</h4> <a href=\"" + serviceUrl + "\" target=\"_blank\"> " + serviceUrl+ " </a>" +
                "</body></html>";
    }

    @GetMapping("/uid")
    public String uid()
    {
        return "s2487866";
    }

    @PostMapping("/distanceTo")
    public Double distanceTo(@RequestBody Position position1, @RequestBody Position position2)
    {
        MathContext mathContext = new MathContext(10);
        BigDecimal lat1 =  position1.getLatitude();
        BigDecimal lng1 =  position1.getLongitude();
        BigDecimal lat2 =  position2.getLatitude();
        BigDecimal lng2 =  position2.getLongitude();

        BigDecimal latDiff = lat2.subtract(lat1);
        BigDecimal lngDiff = lng2.subtract(lng1);
        BigDecimal latSqr = latDiff.multiply(latDiff);
        BigDecimal lngSqr = lngDiff.multiply(lngDiff);
        BigDecimal distSqr = latSqr.add(lngSqr);
        BigDecimal dist = distSqr.sqrt(mathContext);

        return dist.doubleValue();
    }


}


