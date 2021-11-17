package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InternetOrder implements Order{
    private CloseLinkedList<Item> dishes = new CloseLinkedList<>();
    private int size = 0;
    private Customer customer;
    private Item head;
    @Override
    public boolean add(Item dish){
        dishes.add(dish);
        if (size == 0)
            head = dish;
        size++;
        return true;
    }
    @Override
    public boolean remove(String dishName){
        for (Item i : dishes){
            if (i.getName().equals(dishName))
                return dishes.remove(i);
        }
        return false;
    }
    @Override
    public boolean remove(Item dish){
        for (Item i : dishes){
            if (i.getName().equals(dish.getName()))
                return dishes.remove(i);
        }
        return false;
    }
    @Override
    public void removeAll(String dishName){
        for (Item i : dishes)
            if (i.getName().equals(dishName))
                dishes.remove(i);
    }
    @Override
    public void removeAll(Item dish){
        for (Item i : dishes)
            if (i.getName().equals(dish.getName()))
                dishes.remove(i);
    }
    @Override
    public void readDish(){
        System.out.print("\n");
        for (Item i : dishes){
            System.out.println(i.getName()+" "+i.getDiscription()+" "+i.getPrice());
        }
    }
    @Override
    public int dishQuantity(){
        return size;
    }
    @Override
    public int dishQuantity(Item dish){
        int count = 0;
        for (Item i : dishes){
            if (i.getName().equals(dish.getName()))
                count++;
        }
        return count;
    }
    @Override
    public int dishQuantity(String dishName){
        int count = 0;
        for (Item i : dishes){
            if (i.getName().equals(dishName))
                count++;
        }
        return count;
    }
    @Override
    public CloseLinkedList<Item> getDishes(){
        return dishes;
    }
    @Override
    public double costTotal(){
        int totalCost =0;
        for (Item i : dishes){
            totalCost += i.getPrice();
        }
        return totalCost;
    }
    @Override
    public String dishesName(){
        String list = "Список блюд:\n";
        for (Item i : dishes){
            list += i.getName()+"\n";
        }
        return list;
    }
    @Override
    public CloseLinkedList<Item> sortedDishesByCostD(){
        CloseLinkedList<Item> sorted = dishes;
        sorted.sort(Comparator.comparing(Item::getPrice));
        CloseLinkedList<Item> reversed = new CloseLinkedList<>();
        for(Item i : dishes){
            reversed.addFirst(i);
        }
        return reversed;
    }
    @Override
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    @Override
    public Customer getCustomer(){
        return customer;
    }
}
