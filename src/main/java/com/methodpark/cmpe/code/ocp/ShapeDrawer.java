package com.methodpark.cmpe.code.ocp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeDrawer extends JPanel
{
    private static final long serialVersionUID = 1L;
    private ArrayList<IShape> myShapesToDraw;
    @SuppressWarnings("unused")
    private JFrame myJFrame;

    public ShapeDrawer(ArrayList<IShape> shapesToDraw )
    {
        myShapesToDraw = shapesToDraw;
        myJFrame = setupJFrame();
    }

    public void paint(Graphics graphics)
    {    
        Graphics2D graphics2d = setupGraphics(graphics);
        
        // we let the shape subclasses decide how they want to be drawn (but do not let them do the actual drawing) 
        //   by letting them do the graphics setup
        for ( IShape shape : myShapesToDraw )
        {
            shape.setupGraphics(graphics2d);
        }
    }

    public void drawShapesInGui()
    {
        // we cannot delegate this to the shape subclasses, because we need to call the overwritten (re-)paint methods here.
        // if we let the subclasses do this, too, then they would be far more than just "shapes" - they would
        // be "shapeDrawers"
        repaint();
    }   

    public void drawShapesOnConsole()
    {
        // let the subclasses decide how they are drawn on the console.
        for ( IShape shapeToDraw : myShapesToDraw )
        {
            shapeToDraw.drawOnConsole();
        }        
    }

    private JFrame setupJFrame()
    {
        JFrame frame = new JFrame("My Shape Drawer");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    private Graphics2D setupGraphics(Graphics graphics)
    {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.drawString("Shape Drawer", 10, 10);
        return graphics2d;
    }

    public static void main(String[] args)
    {
        IShape circle = new Circle(30);
        IShape square = new Square(20);
        IShape rectangle = new Rectangle(30, 50);
        ArrayList<IShape> shapes = new ArrayList<IShape>();
        shapes.add( circle );
        shapes.add( square );
        shapes.add( rectangle );

        ShapeDrawer drawer = new ShapeDrawer( shapes ); 
        drawer.drawShapesOnConsole();
        drawer.drawShapesInGui();
    }
}