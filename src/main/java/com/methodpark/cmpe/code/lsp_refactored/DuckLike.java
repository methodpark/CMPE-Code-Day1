package com.methodpark.cmpe.code.lsp_refactored;

import java.util.ArrayList;

public abstract class DuckLike {
    
    protected String duckType;
    protected ArrayList<DuckBehavior> behaviors = new ArrayList<DuckBehavior>();

    // this is the only behavior that all subclasses have in common.
    public void display()
    {
        System.out.println("This is a " + duckType + " duck.");
    }
    
    public void performBehaviors() {
        if ( behaviors.isEmpty() )
        {
            System.out.println("I can't do anything. Sorry!");
            return;
        }
        else
        {
            int numberOfBehaviors = behaviors.size();
            System.out.println("I know " + numberOfBehaviors + " behaviors.");
        }
        
        for ( DuckBehavior behavior : behaviors )
        {
            behavior.Perform();
        }
    }
}

