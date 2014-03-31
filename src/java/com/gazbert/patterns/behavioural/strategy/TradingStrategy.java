package com.gazbert.patterns.behavioural.strategy;

/**
 * This is the Strategy.
 * <p>
 * Each Concrete Strategy must process the data passed to it, create a new trade order, and send it off to 
 * the exchange. 
 * <p>
 * @author gazbert
 *
 */
public interface TradingStrategy {
    
    /**
     * This is the Strategy operation all subclasses must provide an algo for.
     * 
     * @param openOrders the current active order book.
     */
    public void execute(OrderBook openOrders);
}
