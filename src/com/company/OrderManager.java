package com.company;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders = new ArrayList<>();
    boolean[] tableFreeArray; //Предположим что столов 20
    public OrderManager(int tableQuantity){
        tableFreeArray = new boolean[tableQuantity];
        for (int i =0;i<tableQuantity;i++){
            tableFreeArray[i] = false;
        }
    }
    public void add(Order order, int tableNumber){
        orders.add(tableNumber, order);
        tableFreeArray[tableNumber] = true;
    }
    public Order getOrder(int tableNumber){
        return orders.get(tableNumber);
    }
    public void addDish(Item dish, int tableNumber){
        orders.get(tableNumber).add(dish);
    }
    public void removeOrder(int tableNumber){
        orders.remove(tableNumber);
        tableFreeArray[tableNumber] = false;
    }
    public int freeTableNumber(){
        int numb =0;
        for (int i =0;i<tableFreeArray.length;i++){
            if (!tableFreeArray[i]){
                numb = i;
                return numb;
            }
        }
        return -1;
    }
    public int[] freeTableNumbers(){
        int size = 0;
        for (int i =0;i<tableFreeArray.length;i++)
            if (!tableFreeArray[i])
                size++;
        int[] number = new int[size];
        int count =0;
        for (int i =0;i<tableFreeArray.length;i++)
            if (!tableFreeArray[i]) {
                number[count] = i;
                count++;
            }
        return number;
    }
    public ArrayList<Order> getOrders(){
        return orders;
    }
    public double orderCostSummary(){
        double cost = 0;
        for (Order i : orders){
            cost += i.costTotal();
        }
        return cost;
    }
    public int dishQuantity(String dishName){
        int count = 0;
        for (Order i : orders){
            count += i.dishQuantity(dishName);
        }
        return count;
    }
    public void readOrder(){
        System.out.print("\n");
        for (Order i : orders){
           i.readDish();
        }
    }
}
