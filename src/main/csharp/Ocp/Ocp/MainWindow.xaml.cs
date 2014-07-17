using System.Collections.Generic;
using System.Windows;

namespace Ocp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            DrawShapes();
        }

        private void DrawShapes()
        {
            var shapes = new List<Shape>();

            shapes.Add(new Circle(30));
            shapes.Add(new Square(70));
            shapes.Add(new Circle(30));
            shapes.Add(new Circle(30));
            shapes.Add(new Square(20));

            var drawer = new ShapeDrawer();
            drawer.DrawShapesOnConsole(shapes);
            drawer.DrawShapesOnCanvas(shapes, canvas);
        }
    }
}