namespace BearGame
{
    internal class Walking : Activity
    {
        public override void DoIt(Bear bear)
        {
            bear.BearIs("walking");
            bear.DrainEnergy(10);
        }
    }
}