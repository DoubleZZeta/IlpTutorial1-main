package uk.ac.ed.acp.cw2.configuration;

import lombok.Getter;

@Getter
public class Plane
{
    private final Position position;
    private final Region region;

    public Plane(final Position position, final Region region)
    {
        this.position = position;
        this.region = region;
    }

}
