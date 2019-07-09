package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(RN.nextInt() + System.currentTimeMillis());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                items[i].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[position];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null) {
                if (items[i].getName().equals(key)) {
                    tmp[count++] = items[i];
                }
            }
        }
        Item[] result = Arrays.copyOf(tmp, count);

        return result.length == 0 ? null : result;
    }
}
