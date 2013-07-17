package com.methodpark.cmpe.code.lsp_refactored;

public class MallardDuck extends DuckLike
{   
    public MallardDuck() 
    {
        duckType = "mallard";
        behaviors.add( new QuackBehavior() );
        behaviors.add( new FlyBehavior() );
        behaviors.add( new SwimBehavior() );
    }
}
