package uk.ac.ed.acp.cw2.configuration;

import lombok.Getter;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
public class Region
{
    private final String name;
    private final ArrayList<Position> vertices = new ArrayList<>();

    public Region (String name, ArrayList<Position> vertices)
    {
        this.name = name;
        this.vertices.addAll(vertices);

    }

//    public Position getMinLngVertex()
//    {
//        BigDecimal minLng = vertices.getFirst().getLng();
//        Position min = vertices.getFirst();
//        for (Position vertex : vertices)
//        {
//            if (vertex.getLng().compareTo(minLng) < 0)
//            {
//                minLng = vertex.getLng();
//                min = vertex;
//            }
//        }
//        return min;
//    }
}
