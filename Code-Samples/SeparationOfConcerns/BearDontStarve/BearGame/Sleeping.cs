namespace BearGame
{
    internal class Sleeping : Activity
    {
        public override void DoIt(Bear bear)
        {
            bear.BearIs("sleeping (zzzzZZZ)");
            bear.DrainEnergy(1);
        }
    }
}