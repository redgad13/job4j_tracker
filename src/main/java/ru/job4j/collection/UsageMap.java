package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("vadim_kuzin@list.ru", "Vadim Kuzin");
        map.put("vadim_kuzin@list.com", "Vadim Kuzin");
        map.put("vadim_kuzin@list.uk", "Vadim Kuzin");

        for (Map.Entry<String, String> s : map.entrySet()
        ) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
