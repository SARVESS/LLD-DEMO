package Bidder;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(String name, int bidAmount);
    String getName();
}
