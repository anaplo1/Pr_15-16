package com.company;

public class Drink implements Item, Alcoholable{
    private final double price;
    private final String discription;
    private final String name;
    private DrinkTypeEnum drinkTypeEnum;

    public Drink(String name, String discription, DrinkTypeEnum drinkTypeEnum) throws IllegalArgumentException{
        this.name = name;
        this.discription = discription;
        this.price = 0;
        this.drinkTypeEnum = drinkTypeEnum;
        if (price < 0)
            throw new IllegalArgumentException("Цена блюда не может быть отрицательной");
        if (name.equals(""))
            throw new IllegalArgumentException("Имя блюда не может быть пустым");
        if (discription.isEmpty())
            throw new IllegalArgumentException("Описание блюда не может быть пустым");
    }
    public Drink(String name, String discription, int price, DrinkTypeEnum drinkTypeEnum) throws IllegalArgumentException{
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.drinkTypeEnum = drinkTypeEnum;
        if (price < 0)
            throw new IllegalArgumentException("Цена напитка не может быть отрицательной");
        if (name.equals(""))
            throw new IllegalArgumentException("Имя напитка не может быть пустым");
        if (discription.isEmpty())
            throw new IllegalArgumentException("Описание напитка не может быть пустым");
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
    @Override
    public boolean isAlcoholicDrink(){
        if (drinkTypeEnum.getAlcoholVol() !=0)
            return true;
        else
            return false;
    }
    @Override
    public double getAlcoholVol(){
        return drinkTypeEnum.getAlcoholVol();
    }
}
