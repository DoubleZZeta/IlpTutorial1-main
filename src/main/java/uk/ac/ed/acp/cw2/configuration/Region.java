package uk.ac.ed.acp.cw2.configuration;

import java.awt.*;
import java.util.ArrayList;

public class Region
{
    private final String name;
    private final ArrayList<Position> vertices = new ArrayList<>();

    public Region (ArrayList<Position> vertices, String name)
    {
        this.vertices.addAll(vertices);
        this.name = name;

    }

    public ArrayList<Position> getVertices()
    {
        return vertices;
    }

    public String getName()
    {
        return name;
    }
}
