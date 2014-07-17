namespace Ocp
{
    public class Circle : Shape
    {
        public double Radius { get; set; }

        public Circle(double radius)
        {
            Radius = radius;
            Type = ShapeType.Circle;
        }
    }
}