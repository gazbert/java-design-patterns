package com.gazbert.patterns.behavioural.strategy;

/**
 * A Concrete Strategy impl.
 *  
 * @author gazbert
 *
 */
public class DoubleTopStrategy implements TradingStrategy {

    @Override
    public void execute(final OrderBook orders) {
	
	System.out.println("Strategy Used: " + this.getClass().getSimpleName());
	
	/*
	 * Code goes in here to impl algo for deciding order to build using past trading history and what's
	 * currently in the order book...
	 *  
	 * I'm just hard coding stuff for demo!
	 * 
	 * Algo decided not to create new order on this occasion.
	 */	
	final Order noOrderThisTimeThanks = new NullOrder();
	
	// Don't send any order off to exchange...
    }
}
