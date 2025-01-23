package com.skypro;

import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;

public class JavaProMain {
    public static void main(String[] args) {
        System.out.println("Skypro Uni - Java Professional start!");
        multiExceptionCatch();
    }

    private static void toTrowOrNotToTrow(boolean exception) throws Exception {
        System.out.println("JavaProMain.toTrowOrNotToTrow");
        if (exception) {
            throw new Exception();
        }
        System.out.println("toTrowOrNotToTrow end.");
    }

    private static void multiExceptionCatch() {
        try {
            System.out.printf("Hello, %f", 1);
        } catch (IllegalFormatConversionException e) { // cначала ловяться дети,
            System.out.println("caught (поймал) IllegalFormatConversionException!");
        } catch (IllegalFormatException e) { // а потом ловятся родители
            System.out.println("caught (поймал) IllegalFormatException!");
        }
    }

    private static void throwInCatch(){
        try {
            System.out.printf("Hello, %f", 1);
        } catch (IllegalFormatConversionException e) { // cначала ловяться дети,
            System.out.println("caught (поймал) IllegalFormatConversionException!");
        } catch (IllegalFormatException e) { // а потом ловятся родители
            System.out.println("caught (поймал) IllegalFormatException!");
        }


    }
}

