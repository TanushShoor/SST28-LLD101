package strategy;

import model.RateLimitConfig;

import java.util.*;

public class SlidingWindowStrategy implements RateLimitingStrategy {

    private Map<String, Deque<Long>> map;
    private RateLimitConfig config;

    public SlidingWindowStrategy(RateLimitConfig config) {
        this.config = config;
        this.map = new HashMap<>();
    }

    @Override
    public synchronized boolean allowRequest(String key) {

        long currentTime = System.currentTimeMillis();

        map.putIfAbsent(key, new LinkedList<>());
        Deque<Long> timestamps = map.get(key);

        // remove old timestamps
        while (!timestamps.isEmpty() &&
                currentTime - timestamps.peekFirst() > config.getWindowSizeInMillis()) {
            timestamps.pollFirst();
        }

        if (timestamps.size() < config.getMaxRequests()) {
            timestamps.addLast(currentTime);
            return true;
        }

        return false;
    }
}