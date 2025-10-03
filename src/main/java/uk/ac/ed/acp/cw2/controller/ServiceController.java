package uk.ac.ed.acp.cw2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import uk.ac.ed.acp.cw2.configuration.*;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Controller class that handles various HTTP endpoints for the application.
 * Provides functionality for serving the index page, retrieving a static UUID,
 * and managing key-value pairs through POST requests.
 */
@RestController()
@RequestMapping("/api/v1")
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    private static final BigDecimal unit = new BigDecimal("0.00015");

    @Value("${ilp.service.url}")
    public URL serviceUrl;

    @GetMapping("/")
    public String index() {
        return "<html><body>" +
                "<h1>Welcome from ILP</h1>" +
                "<h4>ILP-REST-Service-URL:</h4> <a href=\"" + serviceUrl + "\" target=\"_blank\"> " + serviceUrl + " </a>" +
                "</body></html>";
    }

    @GetMapping("/uid")
    public String uid() {
        return "s2487866";
    }

    @PostMapping("/distanceTo")
    public Double distanceTo(@RequestBody Line line) {

        Position position1 = line.getPosition1();
        Position position2 = line.getPosition2();

        BigDecimal dist = calculateDistance(position1, position2);

        return dist.doubleValue();
    }

    @PostMapping("/isCloseTo")
    public boolean isCloseTo(@RequestBody Line line) {

        Position position1 = line.getPosition1();
        Position position2 = line.getPosition2();

        BigDecimal dist = calculateDistance(position1, position2);

        return dist.compareTo(unit) <= 0;
    }

    @PostMapping("/nextPosition")
    public Position nextPosition(@RequestBody Move move) {
        Position position = move.getStart();
        double angle = move.getAngle();

        BigDecimal lng = position.getLng();
        BigDecimal lat = position.getLat();

        double sinValue = Math.sin(angle);
        double cosValue = Math.cos(angle);

        lng = lng.add(unit.multiply(BigDecimal.valueOf(sinValue)));
        lat = lat.add(unit.multiply(BigDecimal.valueOf(cosValue)));

        return new Position(lat, lng);
    }

    @PostMapping("/isInRegion")
    public boolean isInRegion(@RequestBody Plane plane)
    {
        // A ray from the point to the right
        int count = 0;

        ArrayList<Line> lines = calculateRegionLines(plane.getRegion().getVertices());
        Position vertex = plane.getPosition();

        for (Line line : lines)
        {
            if (isSegmentIntersectWithRay(vertex, line))
            {
                count++;
            }
        }

        return count % 2 != 0;
    }

    private BigDecimal calculateDistance(Position position1, Position position2) {
        MathContext mathContext = new MathContext(10);

        BigDecimal lat1 = position1.getLat();
        BigDecimal lng1 = position1.getLng();
        BigDecimal lat2 = position2.getLat();
        BigDecimal lng2 = position2.getLng();

        BigDecimal latDiff = lat2.subtract(lat1);
        BigDecimal lngDiff = lng2.subtract(lng1);
        BigDecimal latSqr = latDiff.multiply(latDiff);
        BigDecimal lngSqr = lngDiff.multiply(lngDiff);
        BigDecimal distSqr = latSqr.add(lngSqr);
        return distSqr.sqrt(mathContext);
    }

    private ArrayList<Line> calculateRegionLines(ArrayList<Position> positions) {
        positions.add(positions.getFirst());
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < positions.size() - 1; i++) {
            Position position1 = positions.get(i);
            Position position2 = positions.get(i + 1);
            lines.add(new Line(position1, position2));
        }
        return lines;
    }

    private boolean isSegmentIntersectWithRay(Position position, Line line) {
        Position right = line.getPosition2();
        Position up = line.getUpperPosition();
        Position down = line.getLowerPosition();

        boolean SegmentOnRight = true;
        boolean SegmentIntersectRay = true;

        if (right.getLng().compareTo(position.getLng()) < 0)
        {
            SegmentOnRight = false;
        }
        if (up.getLat().compareTo(position.getLat()) < 0 || down.getLat().compareTo(position.getLat()) > 0)
        {
            SegmentIntersectRay = false;
        }

        return SegmentOnRight && SegmentIntersectRay;
    }

}


