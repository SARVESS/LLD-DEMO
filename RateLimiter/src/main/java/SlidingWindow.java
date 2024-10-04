import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {
   private final Duration windowSize;
   private final long maxRequests;
   private final Queue<Instant> requestTimeStamps;

   public SlidingWindow(Duration windowSize, long maxRequests) {
       this.windowSize = windowSize;
       this.maxRequests = maxRequests;
       this.requestTimeStamps = new LinkedList<>();
   }

   public synchronized boolean allowRequest() {
       removeOldRequests();
       return requestTimeStamps.size() < maxRequests;
   }

   public synchronized void recordRequest() {
       requestTimeStamps.offer(Instant.now());
   }

   private void removeOldRequests() {
       Instant cutoff = Instant.now().minus(windowSize);
       while(!requestTimeStamps.isEmpty() && requestTimeStamps.peek().isBefore(cutoff)) {
           requestTimeStamps.poll();
       }
   }
}
