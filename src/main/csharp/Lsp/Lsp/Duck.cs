using System;

namespace Lsp
{
    public abstract class Duck
    {
        public virtual void Quack()
        {
            Console.WriteLine("quaak");
        }

        public virtual void Swim()
        {
            Console.WriteLine("splash splash");
        }

        public abstract void Display();

        public virtual void Fly()
        {
            Console.WriteLine("flap flap flap");
        }
    }
}