package com.methodpark.cmpe.code.lsp_refactored;

public class RubberDuck extends DuckLike
{
    public RubberDuck()
    {
        duckType = "rubber";
        behaviors.add( new SqueekBehavior() );
        behaviors.add( new SwimBehavior() );
        // a rubberDuck can't fly
    }

}
