package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Order A = new InternetOrder();
        Dish d1 = new Dish("Горденблю", "Лучшее блюдо на планете земля!", 2);
        Dish d2 = new Dish("Ростбиф", "Лучшее блюдо на планете земля!", 4);
        Dish d3 = new Dish("карнишон", "Лучшее блюдо на планете земля!", 0);
        Drink drink = new Drink("Пинакалада","Лучший напиток на планете хемля!",7);

        Order B = new RestaurantOrder();
        Dish d4 = new Dish("Абрикос", "Лучшее блюдо на планете земля!", 3);
        Dish d5 = new Dish("Рататуй", "Лучшее блюдо на планете земля!", 2);
        Dish d6 = new Dish("Стейк", "Лучшее блюдо на планете земля!", 1);

        Order C = new RestaurantOrder();
        Drink VODKA = new Drink("Водка","Нектар богов!",21);
        Drink PIVO = new Drink("Пиво","Нектар богов!",11);
        Drink CHAI = new Drink("Чай","Вкусной напиток, веющий английским калоритом!",10);
        A.add(d1);
        A.add(d2);
        A.add(drink);
        A.add(d3);
        B.add(d4);
        B.add(d5);
        B.add(d6);
        C.add(VODKA);
        C.add(PIVO);
        C.add(CHAI);
        A.remove("Горденблю");
        CloseLinkedList<Item> sorted = A.sortedDishesByCostD();
        OrderManager orderManager = new OrderManager(20);
        orderManager.add(A,0);
        orderManager.add(B,1);
        orderManager.add("ул. Братеевская д.21",C);
        //orderManager.removeOrder(1);
        System.out.print("\nВывод внесенных заказов в ресторане: ");
        orderManager.readOrders();

        System.out.print("\nВывод внесенных онлайн заказов: ");
        HashMap<String,Order> read = orderManager.getAddressedOrders();
        orderManager.readAddressedOrders();
        System.out.println("\nНомер ближайшего свободного стола: "+orderManager.freeTableNumber());
        System.out.print("Список свободных столов: ");
        int[] a = orderManager.freeTableNumbers();
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println("\n\nЦена всех заказов в ресторане: "+orderManager.orderCostSummary());
        System.out.println("\nЦена всех онлайн закакзов: "+orderManager.addressedOrderCostSummary());
        System.out.println("\nКоличество заказов типа карнишон: "+orderManager.dishQuantity("карнишон"));
        System.out.println("\nКоличество заказов типа Пиво: "+orderManager.addressedDishQuantity("Пиво"));
    }
}
