package com.company;

import java.util.List;

public interface Order {
    public boolean add(Item dish);
    public boolean remove(String dishName);
    public boolean remove (Item dish);
    public void removeAll(String dishName);
    public void removeAll(Item dish);
    public int dishQuantity();
    public int dishQuantity(String dishName);
    public int dishQuantity(Item dish);
    public CloseLinkedList<Item> getDishes();
    public double costTotal();
    public String dishesName();
    public void readDish();
    public CloseLinkedList<Item> sortedDishesByCostD();
    public void setCustomer(Customer customer);
    public Customer getCustomer();
}
