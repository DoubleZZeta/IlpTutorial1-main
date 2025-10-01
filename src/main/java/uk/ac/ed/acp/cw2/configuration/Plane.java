package uk.ac.ed.acp.cw2.configuration;

public class Plane
{
    private final Position position;
    private final Region region;

    public Plane(final Position position, final Region region)
    {
        this.position = position;
        this.region = region;
    }

    public Position getPosition()
    {
        return position;
    }

    public Region getRegion()
    {
        return region;
    }
}
