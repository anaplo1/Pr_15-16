package com.company;

import java.util.ArrayList;

public interface OrdersManager {
    public int dishQuantity(String dishName);
    public int dishQuantity(Item dish);
    public double ordersCostSummary();
    public int ordersQuantity();
}
