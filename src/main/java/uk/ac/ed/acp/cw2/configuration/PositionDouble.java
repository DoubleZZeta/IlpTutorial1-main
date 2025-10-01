package uk.ac.ed.acp.cw2.configuration;

public class PositionDouble
{
    private final double lat;
    private final double lng;
    public PositionDouble (double lng, double lat)
    {
        this.lat = lng;
        this.lng = lat;
    }

    public double getLatitude()
    {
        return lat;
    }

    public double getLongitude()
    {
        return lng;
    }

    public String toString()
    {
        return lat + ", " + lng;
    }
}
