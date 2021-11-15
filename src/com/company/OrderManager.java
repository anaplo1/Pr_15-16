package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderManager {
    ArrayList<Order> restaurantOrders = new ArrayList<>();
    HashMap<String,Order> adressedOrders = new HashMap<>();
    boolean[] tableFreeArray; //Предположим что столов 20
    public OrderManager(int tableQuantity){
        tableFreeArray = new boolean[tableQuantity];
        for (int i =0;i<tableQuantity;i++){
            tableFreeArray[i] = false;
        }
    }
    public void add(Order restaurantOrder, int tableNumber) throws OrderAlreadyAddedException, IllegalTableNumber{
        if (tableNumber<0 || tableNumber>19)
            throw new IllegalTableNumber("Столика с таким номером не существует");
        if (tableFreeArray[tableNumber])
            throw new OrderAlreadyAddedException("Со столика уже был сделан заказ");
        restaurantOrders.add(tableNumber, restaurantOrder);
        tableFreeArray[tableNumber] = true;
    }
    public void add(String address, Order order){
        adressedOrders.put(address,order);
    }
    public Order getOrder(int tableNumber) throws IllegalTableNumber{
        if (tableNumber<0 || tableNumber>19)
            throw new IllegalTableNumber("Столика с таким номером не существует");return restaurantOrders.get(tableNumber);
    }
    public Order getOrder(String address){return adressedOrders.get(address);}
    public void addDish(Item dish, int tableNumber) throws IllegalTableNumber{
        if (tableNumber<0 || tableNumber>19)
            throw new IllegalTableNumber("Столика с таким номером не существует");
        restaurantOrders.get(tableNumber).add(dish);
    }
    public void addDish(Item dish, String address){adressedOrders.get(address).add(dish);}
    public void removeOrder(int tableNumber){
        restaurantOrders.remove(tableNumber);
        tableFreeArray[tableNumber] = false;
    }
    public void removeOrder(String address){
        adressedOrders.remove(address);
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
        return restaurantOrders;
    }
    public HashMap<String,Order> getAddressedOrders() {return adressedOrders;}
    public double orderCostSummary(){
        double cost = 0;
        for (Order i : restaurantOrders){
            cost += i.costTotal();
        }
        return cost;
    }
    public double addressedOrderCostSummary(){
        double cost =0;
        for (String i : adressedOrders.keySet()){
            cost += adressedOrders.get(i).costTotal();
        }
        return cost;
    }
    public int addressedDishQuantity(String dishName){
        int count =0;
        for (String i : adressedOrders.keySet()){
            count += adressedOrders.get(i).dishQuantity(dishName);
        }
        return count;
    }
    public int dishQuantity(String dishName){
        int count = 0;
        for (Order i : restaurantOrders){
            count += i.dishQuantity(dishName);
        }
        return count;
    }
    public void readOrders(){
        System.out.print("\n");
        for (Order i : restaurantOrders){
            System.out.print("\nЗаказ стола №"+(restaurantOrders.indexOf(i)+1)+": ");
            i.readDish();
        }
    }
    public void readAddressedOrders(){
        System.out.print("\n");
        for (String i : adressedOrders.keySet()){
            System.out.print("\nЗаказ №"+(restaurantOrders.indexOf(i)+2)+": ");
            adressedOrders.get(i).readDish();
        }
    }
}
