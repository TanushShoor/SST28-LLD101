package limiter;

import strategy.RateLimitingStrategy;

public class RateLimiter {

    private RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allow(String key) {
        return strategy.allowRequest(key);
    }
}