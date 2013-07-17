package com.methodpark.cmpe.code.lsp_refactored;

import java.util.ArrayList;

public class SimUDuck
{
    ArrayList<DuckLike> ducks;

    public static void main(String[] args)
    {
        SimUDuck simulator = new SimUDuck();
        simulator.ducks = new ArrayList<DuckLike>();

        simulator.ducks.add(new MallardDuck());
        simulator.ducks.add(new RedheadDuck());
        simulator.ducks.add(new RubberDuck());
        simulator.ducks.add(new DecoyDuck());
        simulator.ducks.add(new DonaldDuck());
        
        simulator.haveFunWithAllTheDucks();
        
    }

    void haveFunWithAllTheDucks()
    {
        for (DuckLike duck : ducks)
        {
            System.out.print("NEXT: ");
            duck.display();
            duck.performBehaviors();
            System.out.println("");
        }
    }

}
