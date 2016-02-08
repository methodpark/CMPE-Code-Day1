package com.methodpark.cmpe.code.ocp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeDrawer extends JPanel
{
    private static final long serialVersionUID = 1L;

    private Square squareToDraw;
    private Circle circleToDraw;
    
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Shape Drawer", 10, 10);
     
        if (squareToDraw != null)
        {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(50, 50 , (int)squareToDraw.length, (int)squareToDraw.length);
        }
        if (circleToDraw != null)
        {
            g2d.setColor(Color.RED);
            g2d.fillOval(100, 100, (int)circleToDraw.radius, (int)circleToDraw.radius);
        }
    }
 
    public void drawShapes(ArrayList<Shape> shapes)
    {
        JFrame frame = new JFrame("My Shape Drawer");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
        
        for (Shape shape : shapes)
        {
            switch (shape.itsType)
            {
            case square:
                squareToDraw = (Square) shape;
                repaint();
                break;
            case circle:
                circleToDraw = (Circle) shape;
                repaint();
                break;
            }
        }
    }
    
    public void drawShapesOnConsole(ArrayList<Shape> shapes)
    {
        for (Shape shape : shapes)
        {
            switch (shape.itsType)
            {
            case square:
                printSquare(((Square) shape).getLength());
                break;
            case circle:
                printCircle(((Circle) shape).getRadius());
                break;
            }
        }
    }

    void printSquare(double length)
    {
        System.out.println("drawing square with side lengh " + length);
    }

    void printCircle(double radius)
    {
        System.out.println("drawing circle with radius " + radius);
    }

    
    public static void main(String[] args)
    {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        
        shapes.add(new Circle(30));
        shapes.add(new Square(20));
        
        ShapeDrawer drawer = new ShapeDrawer(); 
        drawer.drawShapesOnConsole(shapes);
        drawer.drawShapes(shapes);
    }
}
