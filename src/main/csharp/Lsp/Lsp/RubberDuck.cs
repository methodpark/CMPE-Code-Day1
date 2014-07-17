using System;

namespace Lsp
{
    public class RubberDuck : Duck
    {
        public override void Display()
        {
            Console.WriteLine("This is a rubber duck.");
        }

        public override void Quack()
        {
            squeek();
        }

        public override void Fly()
        {
            // Override to do nothing.
        }

        private void squeek()
        {
            Console.WriteLine("squeek");
        }
    }
}