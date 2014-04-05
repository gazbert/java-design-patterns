package com.gazbert.patterns.behavioural.observer.jdkobserver;


/**
 * A Concrete Subject. Also called a Concrete Observable.
 * 
 * @author gazbert
 *
 */
public final class DollarStirlingMarket extends Market
{
	/** 1 single instance of this on the exchange for obvious reasons! */	
	private static final DollarStirlingMarket SINGLE_INSTANCE = new  DollarStirlingMarket();
	
	// lockdown
	private DollarStirlingMarket() {}
	
	/**
	 * Returns singleton.
	 * @return
	 */
	public static Market getInstance()
	{
		return SINGLE_INSTANCE;
	}	
}
