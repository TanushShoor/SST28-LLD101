package strategy;

public interface RateLimitingStrategy {
    boolean allowRequest(String key);
}