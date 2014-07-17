using System;

namespace Lsp
{
    public class DecoyDuck : Duck
    {
        public override void Display()
        {
            Console.WriteLine("This is a wooden decoy duck.");
        }

        public override void Quack()
        {
            // Override to do nothing.
        }

        public override void Fly()
        {
            // Override to do nothing.
        }
    }
}