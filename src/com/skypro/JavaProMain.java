package com.skypro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class JavaProMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Skypro Uni - Java Professional start!");

        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("01", "один");
        map1.put("02", "два");
        map1.put("03", "три");
        map1.put("04", "четыре");
        map1.put("05", "пять");
        map1.put("06", "пять");
        map1.put("07", "пять");
        map1.put("08", "пять");

        System.out.println("map1 = " + map1);

        HashMap<MyKey, MyValue> myMap = new HashMap<>();
        MyKey peremennay = new MyKey(1);
        myMap.put(peremennay, new MyValue("green", 10));
        myMap.put(new MyKey(2), new MyValue("red", 110));
        myMap.put(new MyKey(3), new MyValue("blue", 65));

        System.out.println("myMap = " + myMap);
//        System.out.println("myMap.containsKey((new MyKey(1))) = " + myMap.containsKey((new MyKey(1))));
//        System.out.println("myMap.get(new MyKey(1)) = " + myMap.get(new MyKey(1)));
//        System.out.println("(new MyKey(1)equals(new MyKey(1))) = " + (new MyKey(1).equals(new MyKey(1))));
        System.out.println("myMap.containsKey((peremennay)) = " + myMap.containsKey((peremennay)));
        peremennay.setKey(111); // в итоге не получилось, так как ключи должны быть не иммутабельны, не изменяемы
        // если какой то ключ меняется, то значение потом по этому ключу мы достатть не сможем
        System.out.println("myMap.containsKey((peremennay)) = " + myMap.containsKey((peremennay)));
        System.out.println("myMap.size() = " + myMap.size()); // размер тот же, но значение потерялось
    
    
    }
    

    static class MyKey {
        private int key;

        public MyKey(int key) {
            this.key = key;
        }

        // установим сет? на новое значение поле кей
        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "MyKey{" +
                    "key=" + key +
                    '}';
        }

        public int getKey() {
            return key;
        }
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) return true;
//            if (!(obj instanceof MyKey otherKey)) return false;
//            return key == otherKey.key;
//        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }

        // нажмем контрл + О
        @Override
        public boolean equals(Object obj) {
            // мы сравниваем свой собственный класс
            if (this == obj) {
                return true;
            }
            //если ссылки не сработают, давайте наш обьект обжекст приводить к класу майкей.
            if (obj instanceof MyKey otherKey) { // оператор сравнения instanceof, перемееная otherKey
// сравнивать мы будем по полям (создадим гет у майкей.)
                return this.key == otherKey.getKey();
            } else {
                return false;
            }
        }
    }

    static class MyValue {
        private String color;
        private int temperature;

        public MyValue(String color, int temperature) {
            this.color = color;
            this.temperature = temperature;
        }

//               @Override
//        public int hashCode() {
//            return Objects.hash(color, temperature);
//        }

        @Override
        public String toString() {
            return "MyValue{" +
                    "color='" + color + '\'' +
                    ", temperature=" + temperature +
                    '}';
        }
    }
}