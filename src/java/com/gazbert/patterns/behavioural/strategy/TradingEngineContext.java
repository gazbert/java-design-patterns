package com.gazbert.patterns.behavioural.strategy;

import java.util.Random;

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
     * Business method for client to call.
     * <p>
     * In our demo, the Client is the trading bot providing latest order book it fetched from the Exchange web service.
     * 
     * @param updatedOrderBook
     * @return an order to place on the exchange, or null if strategy decided not to place order based on current data.
     */
    public Order getBuyOrder(final OrderBook updatedOrderBook)    
    {	
	/*
	 * In real-life, the current order book and past trading history would be interpreted/analysed to 
	 * determine which trading strategy to use; the Interpreter pattern would be useful here.
	 * 
	 * I'm going to randomly choose a strategy for purposes of demo; that's how it's done in real world no? ;-)
	 */
	final Random r = new Random();
	int stategyToUse = r.nextInt(3);
	switch (stategyToUse)
	{
	    case 0:
	        currentTradingStrategy = new DoubleBottomStrategy();
	        break;
	        
	    case 1:
	        currentTradingStrategy = new DoubleTopStrategy();
	        break;
	        
	    case 2:
	        currentTradingStrategy = new SupportAndResistance();
	        break;
	        
	    case 3:
	        currentTradingStrategy = new HeadAndShoulders();
	        break;
	        
	    default:
		throw new IllegalArgumentException("Random strategy generator expects int between 0 and 3 inclusive");		
	}
	
	// execute our chosen strategy!
	return currentTradingStrategy.execute(updatedOrderBook);
    }
    
    /**
     * Business method for client to call.
     * <p>
     * In our demo, the Client is the trading bot providing latest order book it fetched from the Exchange web service.
     *      
     * @param updatedOrderBook
     * @return an order to place on the exchange, or null if strategy decided not to place order based on current data.
     */
    public Order getSellOrder(final OrderBook updatedOrderBook)    
    {
	/*
	 * We'd do similar thing here as we did for buy orders...
	 */
	throw new UnsupportedOperationException("Not built this yet... ;-)");
    }    
}
