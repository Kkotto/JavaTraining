package org.example;

public class Main {
    public static void main(String[] args) {
        for (Season season : Season.values()){
            System.out.println(season+ " has name '"+season.getName()+"' and "+season.getCountOfDays()+" days.");
        }
    }
}