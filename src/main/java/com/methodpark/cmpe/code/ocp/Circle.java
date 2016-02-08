package com.methodpark.cmpe.code.ocp;

public class Circle extends Shape
{    
    double radius;
 
    public Circle(double radius)
    {
        this.radius = radius;
        itsType = ShapeType.circle;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
}
