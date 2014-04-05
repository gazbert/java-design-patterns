package com.gazbert.patterns.behavioural.observer.oldskool;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;

/**
 * This is the Observable/Subject.
 * <p>
 * Massively simplified. Use case is that whenever a new order goes in, we update the latest bid price, and notify all
 * bots of the price.
 * <p>
 * For production quality, this lot needs making thread safe etc...
 * <p>
 * 
 * @author gazbert
 *
 */
public abstract class Market
{
	/** The market */
	private MarketType marketType;
	
	/** The current/latest market bid price */
	private BigDecimal lastBidPrice;
	
	/** The observers interested in the price changes */
	private List<MarketObserver> priceObservers;
	
	/**
	 * Constructor initialises our list for storing Observers.
	 */
	public Market()
	{
		priceObservers = new ArrayList<MarketObserver>();		
	}
	
	/**
	 * Register an Observer.
	 * @param observer
	 */
	public void registerPriceOberver(final MarketObserver observer)
	{
		priceObservers.add(observer);		
	}

	/**
	 * Unregister an Observer.
	 * @param observer
	 */
	public void unregisterPriceOberver(final MarketObserver observer)
	{
		priceObservers.remove(observer);
	}
	
	/**
	 * Notifies all Observers of a change.
	 * 
	 * TODO - this is often public in lots of other examples I've seen - why??? Surely better to control access to this
	 * so that Observers are only notified via this class' business methods i.e. createNewBuyOrder?
	 */
	private void notifyObservers()
	{
		// Notify interested parties...
		for (final MarketObserver anObserver : priceObservers)
		{
			anObserver.update(this);
		}		
	}

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