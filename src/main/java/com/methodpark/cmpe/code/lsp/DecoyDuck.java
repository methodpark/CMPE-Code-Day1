package com.methodpark.cmpe.code.lsp;

public class DecoyDuck extends Duck
{
    @Override
    public void display()
    {
        System.out.println("This is a wooden decoy duck.");
    }

    @Override
    public void quack()
    {
        // Override to do nothing.
    }

    @Override
    public void fly()
    {
        // Override to do nothing.
    }

    
}
