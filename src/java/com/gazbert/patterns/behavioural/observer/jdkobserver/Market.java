package com.gazbert.patterns.behavioural.observer.jdkobserver;

import java.math.BigDecimal;
import java.util.Observable;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;

/**
 * This is the Observable/Subject.
 * <p>
 * Massively simplified. Use case is that whenever a new order goes in, we update the latest bid price, and notify all
 * bots of the price.
 * <p>
 * For production quality, this lot needs making thread safe etc...
 * <p>
 * Uses java.util.Observable - cuts down on boiler-plate code, but we can't extend another class :-(
 * <p>
 * 
 * @author gazbert
 *
 */
public abstract class Market extends Observable
{
	/** The market */
	private MarketType marketType;
	
	/** The current/latest market bid price */
	private BigDecimal lastBidPrice;
		
	///////////////////// Business state that when changes, triggers updates ////////////////////////
	
	/**
	 * In real life a proper order would come in here, not just the bid price. Keeping it simple...
	 * 
	 * @param lastBidPrice
	 */
	public void createNewBuyOrder(final BigDecimal lastBidPrice, final MarketType marketType)
	{
		this.lastBidPrice = lastBidPrice;
		this.marketType = marketType;
		
		// tell java.util it's changed
		setChanged();
		notifyObservers();
	}	
	
	public BigDecimal getLastBidPrice()
	{
		return lastBidPrice;
	}

	public MarketType getMarketType()
	{
		return marketType;
	}
}