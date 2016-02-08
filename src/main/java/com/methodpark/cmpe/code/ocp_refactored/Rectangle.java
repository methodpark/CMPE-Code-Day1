package com.methodpark.cmpe.code.ocp_refactored;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle implements IShape
{
    private int length;
    private int width;

    public Rectangle( int length, int width)
    {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void drawOnConsole()
    {
        System.out.println("drawing a rectangle with length " + length + " and width " + width );        
    }

    @Override
    public Graphics2D setupGraphics(Graphics2D graphics2d)
    {
        graphics2d.setColor(Color.YELLOW);
        graphics2d.fillRect(175, 150, (int)width, (int)length);
        return graphics2d;
    }
    

}
