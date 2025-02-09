package com.skypro;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JavaProMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Skypro Uni - Java Professional start!");

        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add("123");
        objects.add(new Cat("orange", "Murzik"));
        objects.add(null);

        System.out.println("objects = " + objects);
        System.out.println("objects [2] = " + objects.get(2));
        objects.remove(1);
        System.out.println("objects = " + objects);
        System.out.println("objects [1] = " + objects.get(1));

        // Не МУТАБЕЛЬНЫЙ лист List.of, можно добавлять по элементно
        List<String> strings = List.of("1", "2", "3"); // запрещено добавлять элемент нулл
        System.out.println("strings = " + strings);

        for (String s : strings) {
            System.out.println("s = " + s);
            System.out.println("s.length = " + s.length());
        }
        // в листе могут быть одинаковые элементы
        System.out.println("есть 1? = " + strings.contains("1")); // проверяет наличие элемента в составе коллекции
        System.out.println("есть 5? = " + strings.contains("5"));


        List<Cat> cats = new ArrayList<>(List.of(new Cat("white", "Pet"), new Cat("black", "Vas")));
        Arrays.asList(); // тоже будет давать неизменяемый лист
        System.out.println("есть Пет белый? = " + cats.contains(new Cat("white", "Pet")));

        cats.sort((o1, o2) -> o1.name.compareTo(o2.name)); // используем лямбды, переопределим методо Comparator. принимает два обьекта, две кошки, мы должны сравнить их между собой
        // суть метода, если обьект слева больше чем обьект справа, то 1. если наоборот, то минус 1, если равны, то 0.
        // мы будем сравнивать по первыой букве имени
        System.out.println("cats = " + cats);

        List<Integer> integers = List.of(10, 2, 3); // так нельзя, так как вью наследуюет свойства всего листа. Если он не изменяемый, то и отрезок будет не изме.
        System.out.println("integers = " + integers);
        List<Integer> subList = integers.subList(0, 1); // вьюшка от индекса 0 до индекса 1, отрезок листа, с которым можно производить операции, которые отражаются и во всем листа
        System.out.println("subList = " + subList);
        subList.addAll(List.of(4, 5, 6));
        System.out.println("subList after= " + subList);
        System.out.println("integers after= " + integers);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return Objects.equals(color, cat.color) && Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, name);
        }
    }

}