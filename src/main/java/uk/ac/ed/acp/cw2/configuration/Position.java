package uk.ac.ed.acp.cw2.configuration;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Position
{
    private final BigDecimal lng;
    private final BigDecimal lat;

    public Position (BigDecimal lng, BigDecimal lat)
    {
        this.lat = lat;
        this.lng = lng;
    }

    public String toString()
    {
        return "{" + "lng: " + lng.toString() + ", " +  "lat: " + lat.toString() + "}";
    }
}
