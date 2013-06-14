using System;

namespace BearGame
{
    public partial class Bear
    {
        private static readonly Random Random = new Random();

        private int hunger;

        public bool Dead { get; private set; }

        public void DoStuff()
        {
            PerformNextActivity();
            MonitorHunger();
            CheckDeathTrigger();
        }

        private void PerformNextActivity()
        {
            Activity activity = GetNextActivity();
            activity.DoIt(this);
        }

        private void CheckDeathTrigger()
        {
            if (hunger > 70)
            {
                BearIs("dead :((");
                Dead = true;
            }
            else if (hunger > 50)
            {
                BearIs("hungry");
            }
        }

        public void BearIs(string doingWhat)
        {
            Console.WriteLine("[hunger={0:D3}] Bear is {1} ...", hunger, doingWhat);
        }

        private static Activity GetNextActivity()
        {
            int rand = Random.Next(24);
            return rand > 16 ? (Activity) new Sleeping() : new Walking();
        }

        partial void MonitorHunger();

        public void DrainEnergy(int amount)
        {
            hunger += amount;
        }
    }
}