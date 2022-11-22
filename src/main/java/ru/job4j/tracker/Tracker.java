package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int id = 0;
        Item[] temp = new Item[items.length];
        for (Item item : items) {
            if (item != null) {
                temp[id] = item;
                id++;
            }
        }
        temp = Arrays.copyOf(temp, id);
        return temp;
    }

    public Item[] findByName(String key) {
        int id = 0;
        Item[] temp = new Item[items.length];
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                temp[id] = item;
                id++;
            }
        }
        temp = Arrays.copyOf(temp, id);
        return temp;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            return true;
        } else {
            return false;
        }
    }
}