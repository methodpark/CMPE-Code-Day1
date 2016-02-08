package com.methodpark.cmpe.code.ocp;

public class Square extends Shape
{
    double length;

    public Square(double len)
    {
        length = len;
        itsType = ShapeType.square;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }
}
