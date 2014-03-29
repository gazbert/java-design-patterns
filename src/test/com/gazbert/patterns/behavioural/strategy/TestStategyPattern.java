package com.gazbert.patterns.behavioural.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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
 * 
 * @author gazbert
 *
 */
public class TestStategyPattern 
{
    /**
     * This is the bot passing latest order book to the trading engine to get next order to put on exchange.
     */
    @Test
    public void testStrategyPattern() {
	
	// The latest Order Book fetched from the exchange.
	final OrderBook latestOrders = new OrderBook();
	
	// Create the Context
	final TradingEngineContext tradingEngineCtx = new TradingEngineContext();
	
	// Get next buy order
	final Order buyOrder = tradingEngineCtx.getBuyOrder(latestOrders);
	
	// Some silly asserts to show how diff strats are used...
	System.out.println("Strategy Used: " + buyOrder.getStrategyUsed());	   
	if (buyOrder.getStrategyUsed().equals("DoubleBottomStrategy"))
	{	    	    
	    assertEquals(buyOrder.getUsdPrice(), new BigDecimal(0.69));
	    assertEquals(buyOrder.getUsdAmount(), new BigDecimal(100));
	    assertEquals(buyOrder.getGbpAmount(), new BigDecimal(69));	   	    
	}
	else if (buyOrder.getStrategyUsed().equals("HeadAndShoulders"))
	{	    
	    assertEquals(buyOrder.getUsdPrice(), new BigDecimal(0.66));
	    assertEquals(buyOrder.getUsdAmount(), new BigDecimal(100));
	    assertEquals(buyOrder.getGbpAmount(), new BigDecimal(66));
	}
	else if (buyOrder.getStrategyUsed().equals("SupportAndResistance"))
	{	    
	    assertEquals(buyOrder.getUsdPrice(), new BigDecimal(0.685));
	    assertEquals(buyOrder.getUsdAmount(), new BigDecimal(100));
	    assertEquals(buyOrder.getGbpAmount(), new BigDecimal(68.5));	   
	}
	else if (buyOrder.getStrategyUsed().equals("DoubleTopStrategy"))
	{	    
	    // in the demo, this strat decides NOT to place a new order
	    assertEquals(buyOrder.getUsdPrice(), new BigDecimal(0));
	    assertEquals(buyOrder.getUsdAmount(), new BigDecimal(0));
	    assertEquals(buyOrder.getGbpAmount(), new BigDecimal(0));	   
	}
    }
}
