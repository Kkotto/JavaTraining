package com.kkotto.model;

public class Person {
    private String name;
    private String surname;
    private int bornYear;

    @Override
    public String toString() {
        StringBuilder resultPersonInfo = new StringBuilder();
        if (name != null) resultPersonInfo.append(name);
        if (surname != null) resultPersonInfo.append(" ").append(surname);
        return resultPersonInfo.toString();
    }

    public int getBornYear() {
        return bornYear;
    }

    public static class Builder {
        private final Person builtPerson;

        public Builder() {
            builtPerson = new Person();
        }

        public Builder addName(String name) {
            builtPerson.name = name;
            return this;
        }

        public Builder addSurname(String surname) {
            builtPerson.surname = surname;
            return this;
        }

        public Builder addYear(int year) {
            builtPerson.bornYear = year;
            return this;
        }

        public Person build() {
            return builtPerson;
        }
    }
}
