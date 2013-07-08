package com.methodpark.cmpe.code.ocp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square implements IShape
{
    double length;

    public Square(double len)
    {
        length = len;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }
    
    public void drawOnConsole()
    {
        System.out.println("drawing square with side lentgh " + length);
    }

    @Override
    public Graphics2D setupGraphics(Graphics2D graphics2d)
    {
        graphics2d.setColor(Color.BLUE);
        graphics2d.fillRect(50, 50 , (int)length, (int)length);
        return graphics2d;
    }
}
