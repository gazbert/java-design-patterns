package com.gazbert.patterns.behavioural.strategy;

/**
 * This is the Strategy.
 * <p>
 * Each Concrete Strategy must process the data passed to it and create a new trade order. 
 * <p>
 * @author gazbert
 *
 */
interface TradingStrategy {
    
    /**
     * This is the Strategy operation all subclasses must provide an algo for.
     * 
     * @param openOrders the current active order book.
     * @return the Order created by the strategy.
     */
    Order execute(OrderBook openOrders);
}
