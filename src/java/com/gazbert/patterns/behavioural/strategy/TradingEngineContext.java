package com.gazbert.patterns.behavioural.strategy;


/**
 * The Context. The trading bot uses this to make new orders based on the latest order book.
 * <p>
 * Clients uses this to execute trades.
 * <p>
 * Very simple impl only deals with USD <> GBP market.
 * <p>
 * @author gazbert
 *
 */
public class TradingEngineContext {
    
    /** The current strategy we are using */
    private TradingStrategy currentTradingStrategy;    
  
    
    /**
     * Constructor defaults to a 'safe' support/resistance strategy.
     */
    public TradingEngineContext()
    {
	currentTradingStrategy = new SupportAndResistance();
    }
    
    /**
     * Returns the current trading strategy.
     * @return
     */
    public TradingStrategy getCurrentTradingStrategy() {
        return currentTradingStrategy;
    }

    /**
     * Allows Clients to set the trading strategy.
     * @param currentTradingStrategy
     */
    public void setCurrentTradingStrategy(TradingStrategy currentTradingStrategy) {
        this.currentTradingStrategy = currentTradingStrategy;
    }

    /**
     * Business method for client to call.
     * <p>
     * In our demo, the Client is the trading bot providing latest order book it fetched from the Exchange web service.
     * <p>
     * The business method sends a new order off to the exchange depending on the chosen trading strategy.
     * 
     * @param latestOrderBook
     */
    public void createNewOrder(final OrderBook latestOrderBook)    
    {	
	currentTradingStrategy.execute(latestOrderBook);
    }   
}
