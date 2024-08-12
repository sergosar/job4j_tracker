package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public boolean add(Item item) {
        item.setId(ids);
        ids++;
        return items.add(item);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        return items.stream().filter(i -> i.getName().equals(key)).collect(Collectors.toList());
    }

    private int indexOf(int id) {
        int result = -1;
        for (Item i : items) {
            if (i.getId() == id) {
                result = items.indexOf(i);
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
    }
}