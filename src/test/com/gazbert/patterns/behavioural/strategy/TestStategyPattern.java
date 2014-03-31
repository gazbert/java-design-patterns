package com.gazbert.patterns.behavioural.strategy;

import org.junit.Test;

/**
 * Demonstrates use of Strategy pattern.
 * <p>
 * I'm using a trading bot as an example here.
 * <p>
 * Scenario is the bot has just made a web service call to the FX exchange to get the latest order book for a given
 * market.  Only using 1 market for the demo: USD <> GBP.
 * <p>
 * To demo the Strategy pattern, the bot is going to use the trading engine context to get next order (if indeed there
 * is one) it needs to place on the FX exchange.
 * <p>
 * In real-world, the current order book and past trading history would be interpreted/analysed to 
 * determine which trading strategy to use; the Interpreter pattern would be useful here.
 * <p>
 * TODO - assert something!
 * <p>
 * 
 * @author gazbert
 *
 */
public class TestStategyPattern 
{    
    /**
     * Bot has recognised a double bottom pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDoubleBottomStrategy() {
	
	// The latest Order Book fetched from the exchange. 
	final OrderBook latestOrders = new OrderBook();
		
	// Create the Context
	final TradingEngineContext tradingEngineCtx = new TradingEngineContext();
	
	// Select the strategy
	tradingEngineCtx.setCurrentTradingStrategy(new DoubleBottomStrategy());
	
	// Create the order and send off to exchange
	tradingEngineCtx.createNewOrder(latestOrders);
    }
    
    /**
     * Bot has recognised a head n shoulders pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingHeadAndShouldersStrategy() {
	
	// The latest Order Book fetched from the exchange. 
	final OrderBook latestOrders = new OrderBook();
		
	// Create the Context
	final TradingEngineContext tradingEngineCtx = new TradingEngineContext();
	
	// Select the strategy
	tradingEngineCtx.setCurrentTradingStrategy(new HeadAndShoulders());
	
	// Create the order and send off to exchange
	tradingEngineCtx.createNewOrder(latestOrders);
    }
    
    /**
     * Bot has recognised a double top pattern pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDoubleTopStrategy() {
	
	// The latest Order Book fetched from the exchange. 
	final OrderBook latestOrders = new OrderBook();
		
	// Create the Context
	final TradingEngineContext tradingEngineCtx = new TradingEngineContext();
	
	// Select the strategy
	tradingEngineCtx.setCurrentTradingStrategy(new DoubleTopStrategy());
	
	// Create the order and send off to exchange
	tradingEngineCtx.createNewOrder(latestOrders);
    }		   

    /**
     * Bot using default strat; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDefaultStrategy() {
	
	// The latest Order Book fetched from the exchange. 
	final OrderBook latestOrders = new OrderBook();
		
	// Create the Context
	final TradingEngineContext tradingEngineCtx = new TradingEngineContext();
	
	// Using default strategy	
	// Create the order and send off to exchange
	tradingEngineCtx.createNewOrder(latestOrders);
    }
}
