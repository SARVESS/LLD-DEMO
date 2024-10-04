import java.time.Duration;
import java.time.Instant;

public class TokenBucket {
    private final long capacity;
    private final double refillRate;
    private double currentTokens;
    private Instant lastRefillTimestamp;

    public TokenBucket(long capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.currentTokens = capacity;
        this.lastRefillTimestamp = Instant.now();
    }

    public synchronized boolean consumeToken(int count) {
        refill();
        if (currentTokens >= count) {
            currentTokens -= count;
            return true;
        }
        return false;
    }

    private void refill() {
        Instant now = Instant.now();
        double timePassed = Duration.between(lastRefillTimestamp, now).toNanos() / 1e9;
        double newTokens = timePassed * refillRate;
        currentTokens = Math.min(capacity, currentTokens + newTokens);
        lastRefillTimestamp = now;
    }
}
