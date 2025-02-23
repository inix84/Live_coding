package com.skypro;

import java.util.*;

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
        peremennay.setKey(1);
        System.out.println("myMap.containsKey((peremennay)) = " + myMap.containsKey((peremennay)));
// если какокго значения в карте нет, то создать его оперативно и работать с ним
        MyValue myValue = myMap.get(new MyKey(4)); // получить значение моей карты по ключику 4
        if (myValue == null) {
            myValue = new MyValue("white", 42);
            System.out.println("myValue = " + myValue);
        }
        // верхние 4 строчки можно переписать одной строчкой

        System.out.println("myValue Or Default compute If Absent= " + myMap.computeIfAbsent(new MyKey(4), k -> new MyValue("white", 99))); // если ключа нет. то создаем, еслиесть, то возвращает старое значение
        System.out.println("myValue Or Default = " + myMap.getOrDefault(new MyKey(4), new MyValue("white", 42)));
        myMap.putIfAbsent(new MyKey(4), new MyValue("brown", 1)); // принимает в себя заранее созданые значения, а не значения, кот вычисляются позже
        System.out.println("myMap put If Absent= " + myMap);
// есть мапы не содержащие всех методов, например ТРИМАП

        NavigableMap<Integer, String> cities = new TreeMap<>(); //первый интерфейс мапы, который поддерживает порядок NavigableMap, такой легче куда то передать
        cities.put(1, "Воркута");
        cities.put(100, "Москва");
        cities.put(10, "С-Пб");
        System.out.println("cities = " + cities); // распечатается в порядке возрастания ключей
        System.out.println("cities.get(100) = " + cities.get(100));
        System.out.println("cities.ceilingEntry(50) = " + cities.ceilingEntry(100)); // метод до ПОТОЛКА 50
        System.out.println("cities.ceilingEntry(50) = " + cities.higherEntry(100)); // строго выше потолка

        Map<Integer, String> unmodifiableMap = Map.of(1,"Воркута",100, "Москва",10, "С-Пб");
        System.out.println(" НЕИЗМЕНЯЕМО unmodifiableMap = " + unmodifiableMap);
        //unmodifiableMap.put(4,"Челябинск");

        Map<Integer, String> unmodifiableMap2 = Collections.unmodifiableMap(cities); // уже существующую мапу
        System.out.println(" НЕИЗМЕНЯЕМО unmodifiableMap2 = " + unmodifiableMap2);
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
// сравнивать мы будем по полям (создадим гет у май-кей.)
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