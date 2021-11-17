package com.company;

import java.util.HashMap;

public class InternetOrdersManager implements OrdersManager{
    private HashMap<String,Order> adressedOrders = new HashMap<>();
    public void add(String address, Order order){
        adressedOrders.put(address,order);
    }
    public Order getOrder(String address){return adressedOrders.get(address);}
    public void addDish(Item dish, String address){adressedOrders.get(address).add(dish);}
    public void removeOrder(String address){
        adressedOrders.remove(address);
    }
    public HashMap<String,Order> getOrders() {return adressedOrders;}
    @Override
    public double ordersCostSummary(){
        double cost =0;
        for (String i : adressedOrders.keySet()){
            cost += adressedOrders.get(i).costTotal();
        }
        return cost;
    }
    @Override
    public int dishQuantity(String dishName){
        int count =0;
        for (String i : adressedOrders.keySet()){
            count += adressedOrders.get(i).dishQuantity(dishName);
        }
        return count;
    }
    @Override
    public int dishQuantity(Item dish){
        int count =0;
        for (String i : adressedOrders.keySet()){
            count += adressedOrders.get(i).dishQuantity(dish.getName());
        }
        return count;
    }
    @Override
    public int ordersQuantity(){
        return adressedOrders.size();
    }
    public void readAddressedOrders(){
        System.out.print("\n");
        for (String i : adressedOrders.keySet()){
            System.out.print("\nИнтернет заказ: ");
            adressedOrders.get(i).readDish();
        }
    }
}
