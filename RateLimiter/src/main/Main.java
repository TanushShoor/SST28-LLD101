package main;

import limiter.RateLimiter;
import limiter.RateLimiterService;
import model.RateLimitConfig;
import strategy.FixedWindowStrategy;
import strategy.SlidingWindowStrategy;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        RateLimitConfig config = new RateLimitConfig(
                5,          // max 5 requests
                60000       // per 60 seconds
        );

        //  SWITCH STRATEGY HERE
        RateLimiter limiter = new RateLimiter(
                new FixedWindowStrategy(config)
                // new SlidingWindowStrategy(config)
        );

        RateLimiterService service = new RateLimiterService(limiter);

        String user = "T1";

        for (int i = 1; i <= 7; i++) {
            service.processRequest(user, true);
        }
    }
}