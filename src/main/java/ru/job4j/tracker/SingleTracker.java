package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {
    private SingleTracker instance = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }
}