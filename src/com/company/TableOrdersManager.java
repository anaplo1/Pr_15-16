package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class TableOrdersManager implements OrdersManager{
    ArrayList<Order> restaurantOrders = new ArrayList<>();
    boolean[] tableFreeArray; //Предположим что столов 20
    public TableOrdersManager(int tableQuantity){
        tableFreeArray = new boolean[tableQuantity];
        for (int i =0;i<tableQuantity;i++){
            tableFreeArray[i] = false;
        }
    }
    public void add(Order restaurantOrder, int tableNumber) throws OrderAlreadyAddedException, IllegalTableNumber{
        if (tableNumber<0 || tableNumber>tableFreeArray.length)
            throw new IllegalTableNumber("Столика с таким номером не существует");
        if (tableFreeArray[tableNumber])
            throw new OrderAlreadyAddedException("Со столика уже был сделан заказ");
        restaurantOrders.add(tableNumber, restaurantOrder);
        tableFreeArray[tableNumber] = true;
    }
    public Order getOrder(int tableNumber) throws IllegalTableNumber{
        if (tableNumber<0 || tableNumber>tableFreeArray.length)
            throw new IllegalTableNumber("Столика с таким номером не существует");return restaurantOrders.get(tableNumber);
    }
    public void addDish(Item dish, int tableNumber) throws IllegalTableNumber{
        if (tableNumber<0 || tableNumber>tableFreeArray.length)
            throw new IllegalTableNumber("Столика с таким номером не существует");
        restaurantOrders.get(tableNumber).add(dish);
    }
    public void removeOrder(int tableNumber){
        restaurantOrders.remove(tableNumber);
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
        return restaurantOrders;
    }
    @Override
    public double ordersCostSummary(){
        double cost = 0;
        for (Order i : restaurantOrders){
            cost += i.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return restaurantOrders.size();
    }

    @Override
    public int dishQuantity(String dishName){
        int count = 0;
        for (Order i : restaurantOrders){
            count += i.dishQuantity(dishName);
        }
        return count;
    }

    @Override
    public int dishQuantity(Item dish) {
        int count = 0;
        for (Order i : restaurantOrders){
            count += i.dishQuantity(dish.getName());
        }
        return count;
    }

    public String readOrders(){
        System.out.print("\n");
        String message="";
        for (Order i : restaurantOrders){
            System.out.print("\nЗаказ стола №"+(restaurantOrders.indexOf(i)+1)+": ");
            i.readDish();
            message += i.dishesName()+"\n";
        }
        return message;
    }
}
