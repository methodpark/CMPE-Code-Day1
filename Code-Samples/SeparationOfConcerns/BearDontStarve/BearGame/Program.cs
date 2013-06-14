using System;

namespace BearGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Bear Don't Starve");
            Console.WriteLine("----------------------------\n");

            var game = new BearGame();
            game.Run();

            Console.ReadKey();
        }
    }
}
