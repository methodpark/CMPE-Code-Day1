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
        
        // Analysis:
        // The problem is that we are using the same abstraction for too many things.
        // That is why some basic behaviors inherited from "Duck" do not apply to the concrete classes.
        // But, as the subclasses HAVE to implement them, they override them with empty implementation,
        //   which "surprises", because that's not what we expect, looking at the Duck base class
        // That is exactly what Liskov says in her principle.
        // In essence, there is a fundamental design flaw here: We want objects that are not REAL instances of the
        //   abstraction (like wooden duck) to deal with any method call the abstraction promises (like quacking)
        // This can't work, and thus there is no meaningful solution.
        //
        // Nevertheless, I came up with this Refactoring approach:
        // Only build abstraction on behavior-basis: IQuackable, IFlyable, etc.
        // Then, make the concrete classes inherit and implement only the behaviors that make sense:
        // class MallardDuck implements IQuackable, IFlyable, ISwimmable
        // class RubberDuck implements IQuackable, ISwimmable  and so on.
        // Of course, this way we lose the polymorphism advantage and cannot call Duck.Swim on every object
        //   because they are not Ducks any more.
        // But that is the point: Rubber ducks are not ducks in the sense that they can do everything a real duck
        //   can do.
        // If we DO want to keep the polymorphism advantage, keep a common abstraction and follow the OCP, 
        //   another solution would be something like this:
        // IBehavior { void Perform() }
        // IQuackBehavior extends IBehavior
        // IFlyBehavior extends IBehavior and so on
        // class AbstractDuckLike
        // { 
        //   ArrayList<IBehaviors> behaviors;
        //   public void PerformBehaviors() {
        //     for ( IBehavior behavior : behaviors )
        //     Behavior.Perform();
        //   }
        // }
        // MallardDuck implements IFlyBehavior, IQuackbehavior, ISwimBehavior, AbstractDuck
        // {
        //   public MallardDuck(IQuackBehavior quackBehavior, IFlyBehavior flyBehavior, ISwimBehavior swimBehavior)
        //   {
        //     myQuackBehavior = quackBehavior;
        //     ...
        //   }
        // }
        // Then, you can call PerfomBehaviors() on any concrete class, and it performs only the behaviors it knows. 
        // Of course, that's kind of a forced abstraction.
        // 
        // In my solution, I did not introduce interfaces for the Behavior classes, because it seemed overkill.
        // Instead, I created an abstract DuckBehavior.
        // There is one "disadvantage": any subClass theoretically can have multiple e.g. SwimBehaviors
        //   by adding them in the constructor.
        // If you want, I can implement the solution mentioned above as well ;-)        
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
