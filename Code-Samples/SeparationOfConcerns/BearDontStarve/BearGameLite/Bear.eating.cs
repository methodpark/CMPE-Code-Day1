using System;

namespace BearGame
{
    public partial class Bear
    {
        partial void MonitorHunger()
        {
            if (hunger > 50)
            {
                Eat(SearchFood());
            }
        }

        private void Eat(IEdible food)
        {
            Console.WriteLine("Eating {0}", food.GetType().Name);
            hunger -= food.NutritionValue;
        }

        private IEdible SearchFood()
        {
            if (random.Next(2) == 1)
            {
                return new Honey();
            }
            return new Fruit();
        }
    }
}