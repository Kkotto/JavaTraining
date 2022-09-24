package org.example;

import static org.example.Constant.*;

public enum Season {
    JANUARY("January", COUNT_OF_DAYS_31), FEBRUARY("February", COUNT_OF_DAYS_28),
    MARCH("March", COUNT_OF_DAYS_31), APRIL("April", COUNT_OF_DAYS_30), MAY("May", COUNT_OF_DAYS_31),
    JUNE("June", COUNT_OF_DAYS_30), JULY("July", COUNT_OF_DAYS_31), AUGUST("August", COUNT_OF_DAYS_31),
    SEPTEMBER("September", COUNT_OF_DAYS_30), OCTOBER("October", COUNT_OF_DAYS_31), NOVEMBER("November", COUNT_OF_DAYS_30),
    DECEMBER("December", COUNT_OF_DAYS_31);

    public final String name;
    public final int countOfDays;

    Season(String name, int countOfDays){
        this.name=name;
        this.countOfDays=countOfDays;
    }

    public String toString(){
        return this.name()+" has "+this.countOfDays+" days.";
    }
}
