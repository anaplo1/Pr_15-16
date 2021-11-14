package com.company;

import java.util.List;

public interface Order {
    public boolean add(Item dish);
    public boolean remove(String dishName);
    public void removeAll(String dishName);
    public int dishQuantity();
    public int dishQuantity(String dishName);
    public CloseLinkedList<Item> getDishes();
    public double costTotal();
    public String dishesName();
    public void readDish();
    public CloseLinkedList<Item> sortedDishesByCostD();
}
