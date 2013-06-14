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
            BearIs(string.Format("eating {0}", food.GetType().Name));
            hunger -= food.NutritionValue;
        }

        private static IEdible SearchFood()
        {
            if (Random.Next(2) == 1)
            {
                return new Honey();
            }
            return new Fruit();
        }
    }
}