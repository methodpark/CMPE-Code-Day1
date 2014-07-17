using System;
using System.Collections.Generic;

namespace Lsp
{
    internal class Program
    {
        private static void Main()
        {
            var ducks = new List<Duck> {new MallardDuck(), new RedheadDuck(), new RubberDuck(), new DecoyDuck()};

            HaveFunWithAllTheDucks(ducks);

            Console.WriteLine("Press enter to exit");
            Console.ReadLine();
        }

        private static void HaveFunWithAllTheDucks(IEnumerable<Duck> ducks)
        {
            foreach (var duck in ducks)
            {
                Console.Write("NEXT: ");
                duck.Display();
                Console.Write("FLYING: ");
                duck.Fly();
                Console.Write("QUACKING: ");
                duck.Quack();
                Console.Write("SWIMMING: ");
                duck.Swim();
                Console.WriteLine();
            }
        }
    }
}