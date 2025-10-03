package uk.ac.ed.acp.cw2.configuration;

import lombok.Getter;

@Getter
public class Move
{
    private final Position start;
    private final double angle;

    public  Move(Position position, double angle)
    {
        this.start = position;
        this.angle = angle;
    }

}
