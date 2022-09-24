package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NUMBERS_AMOUNT=10;
    private static final int NUMBER_BOUND=96;
    private static final int MIN_NUMBER=2;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<NUMBERS_AMOUNT; i++){
            list.add(random.nextInt(NUMBER_BOUND)+MIN_NUMBER);
        }
        System.out.print("All numbers: ");
        for(Integer num : list){
            System.out.print(num+" ");
        }
        Collections.sort(list);
        System.out.println("Max numbers: "+list.get(list.size()-1)+" and "+list.get(list.size()-1-1));
    }
}
