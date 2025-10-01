package uk.ac.ed.acp.cw2.configuration;

import java.math.BigDecimal;

public class Position
{
    private final BigDecimal lat;
    private final BigDecimal lng;
    public Position (BigDecimal lng, BigDecimal lat)
    {

        this.lat = lng;
        this.lng = lat;
    }

    public BigDecimal getLat()
    {
        return lat;
    }

    public BigDecimal getLng()
    {
        return lng;
    }

    public String toString()
    {
        return lat.toString() + " " + lng.toString();
    }
}
