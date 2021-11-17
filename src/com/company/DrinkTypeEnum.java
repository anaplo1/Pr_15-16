package com.company;

public enum DrinkTypeEnum {
    BEER (8), WINE (16), VODKA (56),BRANDY (60), CHAMPAGNE (18),WHISKEY (50),TEQUILA (50),RUM (40),VERMUTH (18),LIQUOR (50),JAGERMEISTER (35), JUICE (0), COFFEE (0), GREEN_TEA (0), BLACK_TEA (0), MILK (0), WATER (0), SODA (0);

    private final double alcoholVol;
    DrinkTypeEnum(double i) {
        this.alcoholVol = i;
    }

    public double getAlcoholVol() {
        return alcoholVol;
    }
}
