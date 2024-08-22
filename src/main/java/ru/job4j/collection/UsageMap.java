package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("example@mail.ru", "Miroshnichenko Sergey Nikolaevich");
        map.put("trulala@yandex.ru", "Сталин Иосиф Виссарионович");
        map.put("example@mail.ru", "Новоеимя Можетбыть Любое");
        map.put("prostopochta@pochta.ru", "Насклонегоры Облако Легкое");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
