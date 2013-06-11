package com.methodpark.cmpe.code.lsp;

public abstract class Duck {
    public void quack() {
        System.out.println("quaak");
    }
    
    public void swim() {
        System.out.println("splash splash");
    }
    
    public abstract void display();
    
    public void fly() {
        System.out.println("flap flap flap");
    }
}

