package com.company;

import java.util.*;

public class Order{
    private ArrayList<Dish> dishes = new ArrayList<>();
    private int size = 0;
    public boolean add(Dish dish){
        dishes.add(dish);
        size++;
        return true;
    }
    public boolean remove(String dishName){
        for (Dish i : dishes){
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
        for (Dish i : dishes){
            System.out.println(i.getName()+" "+i.getDiscription()+" "+i.getPrice());
        }
    }
    public int dishQuantity(){
        return size;
    }
    public int dishQuantity(String dishName){
        int count = 0;
        for (Dish i : dishes){
            if (i.getName().equals(dishName))
                count++;
        }
        return count;
    }
    public List<Dish> getDishes(){
        return dishes;
    }
    public double costTotal(){
        int totalCost =0;
        for (Dish i : dishes){
            totalCost += i.getPrice();
        }
        return totalCost;
    }
    public String dishesName(){
        String list = "Список блюд:\n";
        for (Dish i : dishes){
            list += i.getName()+"\n";
        }
        return list;
    }
    public List<Dish> sortedDishesByCostD(){
        ArrayList<Dish> sorted = dishes;
        Collections.sort(sorted, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sorted;
    }
}
