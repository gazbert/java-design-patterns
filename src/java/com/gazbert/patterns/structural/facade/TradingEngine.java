package com.gazbert.patterns.structural.facade;

/**
 * The main trading engine that fills the orders.
 * 
 * @author gazbert
 *
 */
public class TradingEngine {
    
    public TradingEngine()
    {	
    }

    public void fillBuyOrder(final TradeDetails trade)
    {
	System.out.println("Filling Buy order...");
    }
    
    public void fillSellOrder(final TradeDetails trade)
    {
	System.out.println("Filling Sell order...");
    }
}
