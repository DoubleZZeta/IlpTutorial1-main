package uk.ac.ed.acp.cw2.configuration;

import java.math.BigDecimal;

public class Position
{
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    public Position (BigDecimal lng, BigDecimal lat)
    {
        this.latitude = lng;
        this.longitude = lat;
    }

    public BigDecimal getLatitude()
    {
        return latitude;
    }

    public BigDecimal getLongitude()
    {
        return longitude;
    }
}
