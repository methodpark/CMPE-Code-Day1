using System;

namespace BearGame
{
    public class BearGame
    {
        private static bool running = true;

        private Bear bear = new Bear();

        public void Run()
        {
            var gameLoop = new GameLoop(1000);
            gameLoop.GameTick += Tick;

            while (running);
        }

        private void Tick(TimeSpan deltaTime)
        {
            if (Console.KeyAvailable)
            {
                var key = Console.ReadKey();
                if (key.Key == ConsoleKey.Escape)
                {
                    running = false;
                }
            }
            if (bear.Dead)
            {
                running = false;
                return;
            }
            
            bear.DoStuff();
        }
    }
}