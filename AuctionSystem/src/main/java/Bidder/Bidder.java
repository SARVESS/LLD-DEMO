package Bidder;

import Auction.AuctionMediator;

public class Bidder implements  Colleague {

    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
       this.name = name;
       this.auctionMediator = auctionMediator;
       auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(String bidderName, int bidAmount) {
        System.out.println("Hey Bidder: " + name + " please note that " + bidderName + " has placed a bid of amount: " + bidAmount);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
