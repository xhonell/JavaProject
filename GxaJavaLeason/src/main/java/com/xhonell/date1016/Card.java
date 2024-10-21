package com.xhonell.date1016;

public class Card {
    private String color;
    private int points;

    public Card(String color, int points) {
        this.color = color;
        this.points = points;
    }

    public Card() {
    }

    public void showCard() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "牌面信息：\n" + "\t花色：" + color + "\n\t点数：" + points;
    }
}
