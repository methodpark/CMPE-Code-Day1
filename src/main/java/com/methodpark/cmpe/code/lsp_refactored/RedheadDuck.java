package com.methodpark.cmpe.code.lsp_refactored;

public class RedheadDuck extends DuckLike
{
    public RedheadDuck()
    {
        duckType = "redhead";
        behaviors.add( new QuackBehavior() );
        behaviors.add( new FlyBehavior() );
        behaviors.add( new SwimBehavior() );
    }
}
