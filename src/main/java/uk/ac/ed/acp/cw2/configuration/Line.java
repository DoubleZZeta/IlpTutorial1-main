package uk.ac.ed.acp.cw2.configuration;

import java.math.BigDecimal;

public class Line
{
    private final Position position1;
    private final Position position2;

    public Line(Position position1, Position position2)
    {
        this.position1 = position1;
        this.position2 = position2;
    }

    public Position getPosition1()
    {
        return position1;
    }

    public Position getPosition2()
    {
        return position2;
    }

}
