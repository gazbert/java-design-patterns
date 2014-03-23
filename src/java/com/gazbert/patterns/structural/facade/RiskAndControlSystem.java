package com.gazbert.patterns.structural.facade;

/**
 * Manages the banks credit exposure and keeps tabs on Client credit history/dealings/defaults.
 * 
 * @author gazbert
 *
 */
public class RiskAndControlSystem {

    public void updateClientCreditScore(final TradeDetails trade)
    {
	System.out.println("Updating Client's credit score...");
    }
}
