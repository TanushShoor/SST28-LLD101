classDiagram

class RateLimiter {
    - RateLimitingStrategy strategy
    + allow(String key)
}

class RateLimitingStrategy {
    <<interface>>
    + allowRequest(String key)
}

class FixedWindowStrategy {
    - Map map
    - RateLimitConfig config
    + allowRequest(String key)
}

class SlidingWindowStrategy {
    - Map map
    - RateLimitConfig config
    + allowRequest(String key)
}

class RateLimitConfig {
    - int maxRequests
    - long windowSizeInMillis
}

class RateLimiterService {
    - RateLimiter rateLimiter
    + processRequest(String key, boolean needsExternalCall)
}

RateLimiter --> RateLimitingStrategy
RateLimitingStrategy <|.. FixedWindowStrategy
RateLimitingStrategy <|.. SlidingWindowStrategy
RateLimiterService --> RateLimiter
FixedWindowStrategy --> RateLimitConfig
SlidingWindowStrategy --> RateLimitConfig