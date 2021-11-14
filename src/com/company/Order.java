package com.company;

import java.util.*;

public class Order{
    private ArrayList<Item> dishes = new ArrayList<>();
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
        dishes.removeIf(i -> i.getName().equals(dishName));
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
    public List<Item> getDishes(){
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
    public List<Item> sortedDishesByCostD(){
        ArrayList<Item> sorted = dishes;
        Collections.sort(sorted, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sorted;
    }
}
