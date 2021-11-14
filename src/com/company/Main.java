package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Order A = new Order();
        Dish d1 = new Dish("Горденблю", "Лучшее блюдо на планете земля!", 2);
        Dish d2 = new Dish("Ростбиф", "Лучшее блюдо на планете земля!", 4);
        Dish d3 = new Dish("карнишон", "Лучшее блюдо на планете земля!", 0);
        Drink drink = new Drink("Пинакалада","Лучший напиток на планете хемля!",7);

        Order B = new Order();
        Dish d4 = new Dish("Абрикос", "Лучшее блюдо на планете земля!", 3);
        Dish d5 = new Dish("Рататуй", "Лучшее блюдо на планете земля!", 2);
        Dish d6 = new Dish("Стейк", "Лучшее блюдо на планете земля!", 1);

        A.add(d1);
        A.add(d2);
        A.add(drink);
        A.add(d3);
        B.add(d4);
        B.add(d5);
        B.add(d6);
        A.readDish();
        B.readDish();
        System.out.print("\n");
        List<Item> sorted = A.sortedDishesByCostD();
        for (Item i : sorted){
            System.out.println(i.getName()+" "+i.getDiscription()+" "+i.getPrice());
        }
        OrderManager orderManager = new OrderManager(20);
        orderManager.add(A,0);
        orderManager.add(B,1);
        orderManager.add(B,2);
        System.out.print("\nВывод внесенных заказов: ");
        orderManager.removeOrder(1);
        orderManager.readOrder();

        System.out.println("Номер ближайшего свободного стола: "+orderManager.freeTableNumber());
        System.out.print("Список свободных столов: ");
        int[] a = orderManager.freeTableNumbers();
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println("\nЦена всех заказов: "+orderManager.orderCostSummary());
        System.out.println("\nКоличество заказов типа карнишон: "+orderManager.dishQuantity("карнишон"));
    }
}
