package limiter;

public class RateLimiterService {

    private RateLimiter rateLimiter;

    public RateLimiterService(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void processRequest(String key, boolean needsExternalCall) {

        System.out.println("Processing business logic for key: " + key);

        if (!needsExternalCall) {
            System.out.println("No external call needed.");
            return;
        }

        if (rateLimiter.allow(key)) {
            System.out.println("External API called for key: " + key);
        } else {
            System.out.println("Rate limit exceeded for key: " + key);
        }
    }
}