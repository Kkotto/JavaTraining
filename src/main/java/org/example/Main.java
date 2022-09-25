package org.example;

import java.util.ArrayList;
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
        printArray("All numbers: ", list);
        int maxNumber=getMaxValue(list);
        System.out.println("Max numbers: "+maxNumber+" and "+ getMaxValueInBound(list, maxNumber));
    }

    public static void printArray(String text, List<Integer> array){
        System.out.println(text);
        for(Integer number : array){
            System.out.print(number+" ");
        }
        System.out.println();
    }

    public static int getMaxValue(List<Integer> array){
        int max= array.get(0);
        for(int i=1; i< array.size(); i++){
            if(array.get(i)>max){
                max=array.get(i);
            }
        }
        return max;
    }

    public static int getMaxValueInBound(List<Integer> array, int maxLimit){
        int max= array.get(0);
        for(int i=1; i< array.size(); i++){
            if(array.get(i)>max && array.get(i)<maxLimit){
                max=array.get(i);
            }
        }
        return max;
    }
}
