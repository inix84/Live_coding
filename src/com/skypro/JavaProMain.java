package com.skypro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JavaProMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Skypro Uni - Java Professional start!");

        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add("123");
        objects.add(new Cat("orange", "Murzik"));

        System.out.println("objects = " + objects);
        System.out.println("objects [2] = " + objects.get(2));
        objects.remove(1); // удаление по индексу, это 123
        System.out.println("objects = " + objects);
        System.out.println("objects [1] = " + objects.get(1));// показать элемент № 1
        System.out.println("objects [2] = " + objects.get(2));
        int [] ints = {1,2,3}; // массив интов?  а не лист
        //System.out.println("ints = " + ints); // выведет ints = [I@2d98a335
        System.out.println("ints = " +Arrays.toString(ints));
        ints[1]=0; //remove, но массив не уменьшился в размере
        System.out.println("ints = " +Arrays.toString(ints));

// Не изменяемый лист List.of, можно добавлять по элементно
        List<String> strings = List.of ("1","2","3");
        System.out.println("strings = " +strings);


    }

    // класс Кошка
    static class Cat implements Sound {
        private String color;
        private String name;

        public Cat(String color, String name) {
            this.color = color;
            this.name = name; // возвращаеся к листу new ArrayList<>()
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "color='" + color + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public void sound() {
            System.out.println("meow"); // мяу

        }
    }
}