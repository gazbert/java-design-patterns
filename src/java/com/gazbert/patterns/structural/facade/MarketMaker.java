package com.gazbert.patterns.structural.facade;

/**
 * Market maker system determines the bid-ask spread for the exchange.
 * 
 * @author gazbert
 *
 */
public class MarketMaker {

    public void updateMarketMakingStrategy(final TradeDetails trade)
    {
	System.out.println("Informing MarketMaker about trade so they can refine spread strategy...");
    }
}
