package com.company;

import java.util.HashMap;

import static com.company.DrinkTypeEnum.*;

public class Main {

    public static void main(String[] args) {
        try {
        Order A = new InternetOrder();
        Dish d1 = new Dish("Горденблю", "Лучшее блюдо на планете земля!", 2);
        Dish d2 = new Dish("Ростбиф", "Лучшее блюдо на планете земля!", 4);
        Dish d3 = new Dish("карнишон", "Лучшее блюдо на планете земля!", 0);
        Drink drink = new Drink("Пинакалада","Лучший напиток на планете хемля!",7, LIQUOR);

        Order B = new RestaurantOrder();
        Dish d4 = new Dish("Абрикос", "Лучшее блюдо на планете земля!", 3);
        Dish d5 = new Dish("Рататуй", "Лучшее блюдо на планете земля!", 2);
        Dish d6 = new Dish("Стейк", "Лучшее блюдо на планете земля!", 1);

        Order C = new RestaurantOrder();
            Drink VoDKA = new Drink("Водка","Нектар богов!",21, VODKA);
            Drink PIVO = new Drink("Пиво","Нектар богов!",11, BEER);
            Drink PIVO1 = new Drink("Пиво","Нектар богов!",11, BEER);
            Drink CHAI = new Drink("Чай","Вкусной напиток, веющий английским калоритом!",10, BLACK_TEA);
            A.add(d1);
            A.add(d2);
            A.add(drink);
            A.add(d3);
            B.add(d4);
            B.add(d5);
            B.add(d6);
            C.add(VoDKA);
            C.add(PIVO);
            C.add(PIVO1);
            C.add(CHAI);
            A.remove("Горденблю");
            CloseLinkedList<Item> sorted = A.sortedDishesByCostD();
            TableOrdersManager orderManager = new TableOrdersManager(20);
            InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
                orderManager.add(A, 0);
                orderManager.add(B, 1);
                orderManager.add(B, 2);
            internetOrdersManager.add("ул. Братеевская д.21",C);
                orderManager.removeOrder(1);
            System.out.print("\nВывод внесенных заказов в ресторане: ");
            orderManager.readOrders();

            System.out.print("\nВывод внесенных онлайн заказов: ");
            HashMap<String,Order> read = internetOrdersManager.getOrders();
            for (String i : read.keySet()){ //Есть возможность разлиновать все по списку объектов и вывести его вручную
                read.get(i).readDish();
            }
            internetOrdersManager.readAddressedOrders();
            System.out.println("\nНомер ближайшего свободного стола: "+orderManager.freeTableNumber());
            System.out.print("Список свободных столов: ");
            int[] a = orderManager.freeTableNumbers();
            for (int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
            }

            System.out.println("\n\nЦена всех заказов в ресторане: "+orderManager.ordersCostSummary());
            System.out.println("\nЦена всех онлайн закакзов: "+internetOrdersManager.ordersCostSummary());
            System.out.println("\nКоличество заказов типа карнишон: "+orderManager.dishQuantity("карнишон"));
            System.out.println("\nКоличество заказов типа Пиво: "+internetOrdersManager.dishQuantity("Пиво"));

            orderManager.getOrder(0).readDish();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (OrderAlreadyAddedException e){
            System.out.print(e.getMessage());
        }
        catch (IllegalTableNumber e){
            System.out.print(e.getMessage());
        }
    }
}
