package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(RN.nextInt() + System.currentTimeMillis());
    }

    Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    void replace(String id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                items.get(i).setId(id);
                break;
            }
        }
    }

    boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

   List<Item> findAll() {
        return items;
    }

    List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item x : items) {
            if (x.getName().equals(key)) {
                result.add(x);
            }
        }
        return result.size() == 0 ? null : result;
    }
}
