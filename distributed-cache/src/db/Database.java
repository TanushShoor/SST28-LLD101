package db;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String, String> storage;

    public Database() {
        storage = new HashMap<>();
    }

    public String get(String key) {
        System.out.println("Fetching from DB: " + key);
        return storage.getOrDefault(key, "DB_" + key);
    }

    public void put(String key, String value) {
        storage.put(key, value);
    }
}