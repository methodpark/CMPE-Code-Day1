package com.methodpark.cmpe.code.ocp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle implements IShape
{    
    double radius;
 
    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public void drawOnConsole()
    {
        System.out.println("drawing circle with radius " + radius);        
    }

    @Override
    public Graphics2D setupGraphics(Graphics2D graphics2d)
    {
        graphics2d.setColor(Color.RED);
        graphics2d.fillOval(100, 100, (int)radius, (int)radius);
        return graphics2d;
    }
    
    
    
}
