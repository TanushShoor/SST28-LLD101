package eviction;

import java.util.LinkedHashSet;

public class LRUEvictionPolicy implements EvictionPolicy {

    private LinkedHashSet<String> order;

    public LRUEvictionPolicy() {
        this.order = new LinkedHashSet<>();
    }

    @Override
    public void keyAccessed(String key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public String evictKey() {
        String firstKey = order.iterator().next();
        order.remove(firstKey);
        return firstKey;
    }
}