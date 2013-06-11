package com.methodpark.cmpe.code.lsp;

import java.util.ArrayList;

public class SimUDuck
{
    ArrayList<Duck> ducks;

    public static void main(String[] args)
    {
        SimUDuck simulator = new SimUDuck();
        simulator.ducks = new ArrayList<Duck>();

        simulator.ducks.add(new MallardDuck());
        simulator.ducks.add(new RedheadDuck());
        simulator.ducks.add(new RubberDuck());
        simulator.ducks.add(new DecoyDuck());
        
        simulator.haveFunWithAllTheDucks();
    }

    void haveFunWithAllTheDucks()
    {
        for (Duck duck : ducks)
        {
            System.out.print("NEXT: ");
            duck.display();
            System.out.print("FLYING: ");
            duck.fly();
            System.out.print("QUACKING: ");
            duck.quack();
            System.out.print("SWIMMING: ");
            duck.swim();
            System.out.println();
        }
    }

}
