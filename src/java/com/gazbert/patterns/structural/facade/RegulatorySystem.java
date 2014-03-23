package com.gazbert.patterns.structural.facade;

/**
 * Regulatory system makes sure the trade activity complies with the Treasury and SEC regulations.
 * 
 * @author gazbert
 *
 */
public class RegulatorySystem {

    public void auditTrade(final TradeDetails trade)
    {
	System.out.println("Checking trade for regulatory compliance...");
    }
}
