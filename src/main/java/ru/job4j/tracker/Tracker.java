package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        if (id < items.size()) {
            return items.get(id).getId() != -1 ? items.get(id) : null;
        }
        return null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                temp.add(item);
            }
        }
        return temp;
    }

    public boolean replace(int id, Item item) {
        if (id < items.size()) {
            items.set(id, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (id < items.size()) {
            items.remove(id);
            return true;
        }
        return false;
    }
}