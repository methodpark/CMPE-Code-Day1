using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Shapes;

namespace Ocp
{
    public class ShapeDrawer
    {
        private Square squareToDraw;
        private Circle circleToDraw;

        private readonly Random random = new Random();

        public void DrawShapesOnConsole(List<Shape> shapes)
        {
            foreach (var shape in shapes)
            {
                switch (shape.Type)
                {
                    case ShapeType.Square:
                        PrintSquare(((Square) shape).Length);
                        break;
                    case ShapeType.Circle:
                        PrintCircle(((Circle) shape).Radius);
                        break;
                }
            }
        }

        private static void PrintSquare(double length)
        {
            Console.WriteLine("Drawing square with side lengh " + length);
        }

        private static void PrintCircle(double radius)
        {
            Console.WriteLine("Drawing circle with radius " + radius);
        }

        public void DrawShapesOnCanvas(List<Shape> shapes, Canvas canvas)
        {
            foreach (var shape in shapes)
            {
                switch (shape.Type)
                {
                    case ShapeType.Square:
                        squareToDraw = (Square) shape;
                        circleToDraw = null;
                        PaintShapeOnCanvas(canvas);
                        break;
                    case ShapeType.Circle:
                        circleToDraw = (Circle) shape;
                        squareToDraw = null;
                        PaintShapeOnCanvas(canvas);
                        break;
                }
            }
        }

        private void PaintShapeOnCanvas(Canvas canvas)
        {
            const int border = 50;
            var positionLeft = random.Next(100) + border/2;
            var positionTop = random.Next(100) + border/2;

            if (circleToDraw != null)
            {
                var square = new Ellipse
                {
                    Width = circleToDraw.Radius,
                    Height = circleToDraw.Radius,
                    Stroke = System.Windows.Media.Brushes.IndianRed,
                    StrokeThickness = 2,
                };
                canvas.Children.Add(square);
                Canvas.SetLeft(square, positionLeft);
                Canvas.SetTop(square, positionTop);
            }
            if (squareToDraw != null)
            {
                var circle = new Rectangle
                {
                    Width = squareToDraw.Length,
                    Height = squareToDraw.Length,
                    Stroke = System.Windows.Media.Brushes.CornflowerBlue,
                    StrokeThickness = 2,
                };
                canvas.Children.Add(circle);
                Canvas.SetLeft(circle, positionLeft);
                Canvas.SetTop(circle, positionTop);
            }
        }
    }
}