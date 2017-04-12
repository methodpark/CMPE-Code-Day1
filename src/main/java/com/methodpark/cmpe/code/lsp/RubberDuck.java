package com.methodpark.cmpe.code.lsp;

public class RubberDuck extends Duck
{
    public void display()
    {
        System.out.println("This is a rubber duck.");
    }

    @Override
    public void quack()
    {
        squeek();
    }

    @Override
    public void fly()
    {
        // Override to do nothing.
    }

    void squeek()
    {
        System.out.println("squeak");
    }

}
