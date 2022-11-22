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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int id = 0;
        Item[] temp = new Item[size];
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                temp[id] = items[i];
                id++;
            }
        }
        return Arrays.copyOf(temp, id);
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
        }
        return false;
    }

    public boolean delete(int id) {
        id = indexOf(id);
        if (id == -1) {
            return false;
        }
        System.arraycopy(items, id + 1, items, id, size - id);
        items[size - 1] = null;
        size--;
        return true;
    }
}