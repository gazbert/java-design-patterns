package com.gazbert.patterns.behavioural.observer.jdkeventing;


/**
 * A Subject. Also called a Concrete Observable.
 * 
 * @author gazbert
 *
 */
public class DollarEuroMarket extends Market
{	
	/** 1 single instance of this on the exchange for obvious reasons! */	
	private static final DollarEuroMarket SINGLE_INSTANCE = new  DollarEuroMarket();
	
	// lockdown
	private DollarEuroMarket() {}
	
	/**
	 * Returns singleton.
	 * @return
	 */
	public static Market getInstance()
	{
		return SINGLE_INSTANCE;
	}	
}