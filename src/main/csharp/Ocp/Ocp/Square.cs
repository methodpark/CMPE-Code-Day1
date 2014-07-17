namespace Ocp
{
    public class Square : Shape
    {
        public double Length { get; set; }

        public Square(double len)
        {
            Length = len;
            Type = ShapeType.Square;
        }
    }
}