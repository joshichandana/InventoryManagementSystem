package com.csye7374.inventory.designPattern.state;

public class State {
    private StateAPI state = null;

    public State() {
    }

    public StateAPI getState() {
        return this.state;
    }

    public void setState(StateAPI state) {
        this.state = state;
    }
}