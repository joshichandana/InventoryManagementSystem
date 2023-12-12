package com.csye7374.inventory.designPattern.state;

public class State implements StateAPI {

    public State() {
    }

    @Override
    public void action(int stock) {
        System.out.println("Initial State");
    }

}