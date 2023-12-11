package com.csye7374.inventory.designPattern.state;

public abstract class StateAPI {
    public StateAPI() {
    }

    public abstract void action(State state, int stock);
}