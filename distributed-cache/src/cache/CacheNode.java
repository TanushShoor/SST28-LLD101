package cache;

import eviction.EvictionPolicy;
import java.util.HashMap;
import java.util.Map;

public class CacheNode {

    private int capacity;
    private Map<String, String> map;
    private EvictionPolicy evictionPolicy;

    public CacheNode(int capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.map = new HashMap<>();
    }

    public String get(String key) {
        if (!map.containsKey(key)) {
            return null;
        }

        evictionPolicy.keyAccessed(key);
        return map.get(key);
    }

    public void put(String key, String value) {

        if (map.size() >= capacity) {
            String evictKey = evictionPolicy.evictKey();
            map.remove(evictKey);
        }

        map.put(key, value);
        evictionPolicy.keyAccessed(key);
    }
}