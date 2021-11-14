package com.company;

public class Dish implements Item{
    private final double price;
    private final String discription;
    private final String name;

    public Dish(String name, String discription){
        this.name = name;
        this.discription = discription;
        this.price = 0;
    }
    public Dish(String name, String discription, int price){
        this.name = name;
        this.discription = discription;
        this.price = price;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getDiscription(){
        return discription;
    }
    @Override
    public double getPrice(){
        return price;
    }
}
