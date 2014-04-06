package com.gazbert.patterns.behavioural.observer.jdkeventing;

import java.math.BigDecimal;
import java.util.EventObject;

/**
 * Event sent from the Subject to interested Observers when a new bid price comes in.
 * <p>
 * @author gazbert
 *
 */
public class LatestMarketBidPriceEvent extends EventObject
{	
	/** SID */	
	private static final long serialVersionUID = 3503294561418438023L;
	
	/** The info the Observers are actually interested in */
	private BigDecimal latestBidPrice;	

	/** The market this event is for */
	private MarketType marketType;
	

	/**
	 * Constructor builds the event.
	 * 
	 * @param source where this event came from - don't care for this demo.
	 * @param latestBidPrice the latest bid price.
	 */
	public LatestMarketBidPriceEvent(final Object source, final BigDecimal latestBidPrice, final MarketType marketType)
	{
		super(source);
		this.latestBidPrice = latestBidPrice;
		this.marketType = marketType;
	}
	
	/**
	 * Returns the latest bid price.
	 * @return
	 */
	public BigDecimal getLatestBidPrice()
	{
		return latestBidPrice;
	}

	/**
	 * What da market G?
	 * @return
	 */
	public MarketType getMarketType()
	{
		return marketType;
	}
}
