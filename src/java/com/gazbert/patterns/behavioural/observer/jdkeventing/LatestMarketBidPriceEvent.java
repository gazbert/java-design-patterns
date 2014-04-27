package com.gazbert.patterns.behavioural.observer.jdkeventing;

/*The MIT License (MIT)

Copyright (c) 2014 Gazbert

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

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
