using System;
using System.Timers;

namespace BearGame
{
    public class GameLoop
    {
        public event Action<TimeSpan> GameTick;

        private DateTime lastTick;

        public GameLoop(int interval)
        {
            var gameTimer = new Timer {Interval = interval};
            gameTimer.Elapsed += GameTimer_Tick;
            gameTimer.Start();
            RefreshLastTick();
        }

        private void RefreshLastTick()
        {
            lastTick = DateTime.Now;
        }

        void GameTimer_Tick(object sender, EventArgs e)
        {
            GameTick(DateTime.Now.Subtract(lastTick));
            RefreshLastTick();
        }
    }
}