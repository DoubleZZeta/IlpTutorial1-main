package uk.ac.ed.acp.cw2.configuration;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Line
{
    private final Position position1;
    private final Position position2;

    public Line(Position position1, Position position2)
    {

        this.position1 = position1;
        this.position2 = position2;
    }

    public Position getLeftPosition()
    {
        BigDecimal lng1 = position1.getLng();
        BigDecimal lng2 = position2.getLng();
        if (lng1.compareTo(lng2) < 0)
        {
            return position1;
        }
        return position2;
    }

    public Position getRightPosition()
    {
        BigDecimal lng1 = position1.getLng();
        BigDecimal lng2 = position2.getLng();
        if (lng1.compareTo(lng2) >= 0)
        {
            return position1;
        }
        return position2;
    }

    public Position getUpperPosition()
    {
        BigDecimal lat1 = position1.getLng();
        BigDecimal lat2 = position2.getLng();
        if (lat1.compareTo(lat2) < 0)
        {
            return position1;
        }
        return position2;
    }

    public Position getLowerPosition()
    {
        BigDecimal lat1 = position1.getLng();
        BigDecimal lat2 = position2.getLng();
        if (lat1.compareTo(lat2) >= 0)
        {
            return position1;
        }
        return position2;
    }

}
