package com.gazbert.patterns.structural.facade;

import org.junit.Test;


/**
 * Demonstrates use of Facade pattern.
 * 
 * @author gazbert
 *
 */
public class TestFacadePattern 
{
    /**
     * Trader click Buy button on Exchange UI...
     * UI component builds trade and invokes the Facade...
     * 
     */
    @Test
    public void testTradingFacade() {

	final TradeDetails trade = new TradeDetails();
	final TradingFacade tradingFacade = new TradingFacade();
	tradingFacade.executeBuyOrder(trade);
    } 
}
