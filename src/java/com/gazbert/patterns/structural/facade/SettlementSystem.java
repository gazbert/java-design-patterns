package com.gazbert.patterns.structural.facade;

/**
 * Clears the filled orders in the back office.
 * 
 * @author gazbert
 *
 */
public class SettlementSystem {
    
    public void settle(final TradeDetails trade)
    {
	System.out.println("Queueing up trade in Settlements system for backoffice to clear...");
    }

}
