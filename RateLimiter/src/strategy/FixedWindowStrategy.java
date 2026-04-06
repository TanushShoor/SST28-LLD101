package strategy;

import model.RateLimitConfig;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowStrategy implements RateLimitingStrategy {

    private static class Counter {
        int count;
        long windowStart;

        Counter(int count, long windowStart) {
            this.count = count;
            this.windowStart = windowStart;
        }
    }

    private Map<String, Counter> map;
    private RateLimitConfig config;

    public FixedWindowStrategy(RateLimitConfig config) {
        this.config = config;
        this.map = new HashMap<>();
    }

    @Override
    public synchronized boolean allowRequest(String key) {

        long currentTime = System.currentTimeMillis();

        Counter counter = map.get(key);

        if (counter == null) {
            map.put(key, new Counter(1, currentTime));
            return true;
        }

        if (currentTime - counter.windowStart > config.getWindowSizeInMillis()) {
            // new window
            counter.count = 1;
            counter.windowStart = currentTime;
            return true;
        }

        if (counter.count < config.getMaxRequests()) {
            counter.count++;
            return true;
        }

        return false;
    }
}