package com.gazbert.patterns.behavioural.strategy;

/**
 * A Concrete Strategy impl.
 *  
 * @author gazbert
 *
 */
public class DoubleTopStrategy implements TradingStrategy {

    @Override
    public Order execute(final OrderBook orders) {
	
	/*
	 * Code goes in here to impl algo for deciding order to build using past trading history and what's
	 * currently in the order book...
	 *  
	 * I'm just hard coding stuff for demo!
	 * 
	 * Algo decided not to create new order on this occasion.
	 */	
	final Order noOrderThisTimeThanks = new NullOrder();
	
	// just for logging to show chosen strat - wouldn't do this in real world.
	noOrderThisTimeThanks.setStrategyUsed(this.getClass().getSimpleName());
	
	return noOrderThisTimeThanks;	
    }
}
