import java.time.Duration;

public class RateLimiter {
    private final TokenBucket tokenBucket;
    private final SlidingWindow slidingWindow;

    public RateLimiter(long tokenBucketCapacity, double tokenBucketRefillRate, Duration slidingWindowSize, long slidingWindowMaxRequests) {
        this.tokenBucket = new TokenBucket(tokenBucketCapacity, tokenBucketRefillRate);
        this.slidingWindow = new SlidingWindow(slidingWindowSize, slidingWindowMaxRequests);
    }

    private boolean isAllowed() {
        return tokenBucket.consumeToken(1) && slidingWindow.allowRequest();
    }

    public boolean updateLimiter() {
        if(isAllowed()) {
            slidingWindow.recordRequest();
            return true;
        }
        return false;
    }
}
