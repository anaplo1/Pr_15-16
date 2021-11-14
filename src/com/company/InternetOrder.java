package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InternetOrder {
    private CloseLinkedList<Item> dishes = new CloseLinkedList<>();
    private int size = 0;
    private Item head;
    public boolean add(Item dish){
        dishes.add(dish);
        if (size == 0)
            head = dish;
        size++;
        return true;
    }
    public boolean remove(String dishName){
        for (Item i : dishes){
            if (i.getName().equals(dishName))
                return dishes.remove(i);
        }
        return false;
    }
    public void removeAll(String dishName){
        for (Item i : dishes)
            if (i.getName().equals(dishName))
                dishes.remove(i);
    }
    public void readDish(){
        System.out.print("\n");
        for (Item i : dishes){
            System.out.println(i.getName()+" "+i.getDiscription()+" "+i.getPrice());
        }
    }
    public int dishQuantity(){
        return size;
    }
    public int dishQuantity(String dishName){
        int count = 0;
        for (Item i : dishes){
            if (i.getName().equals(dishName))
                count++;
        }
        return count;
    }
    public CloseLinkedList<Item> getDishes(){
        return dishes;
    }
    public double costTotal(){
        int totalCost =0;
        for (Item i : dishes){
            totalCost += i.getPrice();
        }
        return totalCost;
    }
    public String dishesName(){
        String list = "Список блюд:\n";
        for (Item i : dishes){
            list += i.getName()+"\n";
        }
        return list;
    }
    public CloseLinkedList<Item> sortedDishesByCostD(){
        CloseLinkedList<Item> sorted = dishes;
        sorted.sort(Comparator.comparing(Item::getPrice));
        return sorted;
    }
}
