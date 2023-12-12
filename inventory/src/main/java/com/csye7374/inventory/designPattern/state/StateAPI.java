package com.csye7374.inventory.designPattern.state;

public interface StateAPI {
    void increaseStock(int stock);
    void alertStock(int stock);
}