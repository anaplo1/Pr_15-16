package com.company;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders = new ArrayList<>();
    public void add(Order order, int tableNumber){
        orders.add(tableNumber, order);
    }
    public Order getOrder(int tableNumber){
        return orders.get(tableNumber);
    }
    public void addDish(Item dish, int tableNumber){
        orders.get(tableNumber).add(dish);
    }
    public void removeOrder(int tableNumber){
        orders.remove(tableNumber);
    }
    public int freeTableNumber(){
        int numb =0;
        for (Order i : orders){
            numb++;
            if (i==null)
                return numb;
        }
        return -1;
    }
    public int[] freeTableNumbers(){
        int[] numbArray = new int[20]; //Предположим что столов 20
        int count = 0;
        for (int i =0;i<numbArray.length;i++){
            numbArray[i] =0;
        }
        for (Order i : orders){
            numbArray[orders.indexOf(i)] = 1;
        }
        int[] tablesNumberArray = new int[orders.size()];
        for (int i=0;i<20;i++){
            if (numbArray[i] == 1) {
                tablesNumberArray[count] = i;
                count++;
            }
        }
        return tablesNumberArray;
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
}
