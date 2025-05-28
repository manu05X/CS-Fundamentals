package com.manish.CoreJava.JavaFeatures;

public class EnumExample {
    public EnumExample() {
    }

    public static void main(String[] args) {
        Day today = EnumExample.Day.MONDAY;
        System.out.println("Today is: " + String.valueOf(today));
        switch (today.ordinal()) {
            case 0 -> System.out.println("It's the weekend!");
            case 1 -> System.out.println("Start of the work week.");
            case 5 -> System.out.println("End of the work week.");
            default -> System.out.println("Midweek day.");
        }

        System.out.println("Days of the week:");
        Day[] var2 = EnumExample.Day.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Day day = var2[var4];
            System.out.println(day);
        }

    }

    static enum Day {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        private Day() {
        }
    }
}
