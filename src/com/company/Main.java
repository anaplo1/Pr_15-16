package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Order A = new Order();
        Dish d1 = new Dish("Горденблю", "Лучшее блюдо на планете земля!", 2);
        Dish d2 = new Dish("Ростбиф", "Лучшее блюдо на планете земля!", 4);
        Dish d3 = new Dish("карнишон", "Лучшее блюдо на планете земля!", 0);
        Dish d4 = new Dish("Абрикос", "Лучшее блюдо на планете земля!", 3);
        Dish d5 = new Dish("Рататуй", "Лучшее блюдо на планете земля!", 2);
        Dish d6 = new Dish("Стейк", "Лучшее блюдо на планете земля!", 1);

        Drink drink = new Drink("Пинакалада","Лучший напиток на планете хемля!",7);

        A.add(d1);
        A.add(d2);
        A.add(drink);
        A.add(d3);
        A.add(d4);
        A.add(d5);
        A.add(d6);
        A.readDish();
        System.out.print("\n");
        List<Item> sorted = A.sortedDishesByCostD();
        for (Item i : sorted){
            System.out.println(i.getName()+" "+i.getDiscription()+" "+i.getPrice());
        }
    }
}
