package com.company;

import java.util.*;

public class RestaurantOrder implements Order{
    private ArrayList<Item> dishes = new ArrayList<>();
    private int size = 0;
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
    public void removeAll(String dishName){
        dishes.removeIf(i -> i.getName().equals(dishName));
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
        CloseLinkedList<Item> returned = new CloseLinkedList<Item>();
        returned.addAll(dishes);
        return returned;
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
        CloseLinkedList<Item> sorted = new CloseLinkedList<>();
        sorted.addAll(dishes);
        sorted.sort(Comparator.comparing(Item::getPrice));
        CloseLinkedList<Item> reversed = new CloseLinkedList<>();
        for(Item i : dishes){
            reversed.addFirst(i);
        }
        return reversed;
    }
}
