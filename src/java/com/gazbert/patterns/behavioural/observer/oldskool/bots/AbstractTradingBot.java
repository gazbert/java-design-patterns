package com.gazbert.patterns.behavioural.observer.oldskool.bots;

import java.math.BigDecimal;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;
import com.gazbert.patterns.behavioural.observer.oldskool.Market;
import com.gazbert.patterns.behavioural.observer.oldskool.MarketObserver;

/**
 * This would not exist in real world. Here because I'm too lazy to type same code for each bot.
 * <p>
 * @author gazbert
 *
 */
abstract class AbstractTradingBot implements MarketObserver
{
	/** USD GBP market bid price */
	private BigDecimal latestDollarStirlingMarketBidPrice = new BigDecimal(0.60);
	
	/** USD EUR market bid price */
	private BigDecimal latestDollarEuroMarketBidPrice = new BigDecimal(0.73);
	
	
	public BigDecimal getLatestDollarStirlingMarketBidPrice()
	{
		return latestDollarStirlingMarketBidPrice;
	}
	
	public BigDecimal getLatestDollarEuroMarketBidPrice()
	{
		return latestDollarEuroMarketBidPrice;
	}
	
	/**
	 * The callback when stuff has been updated
	 * 
	 * @param observable
	 */
	@Override
	public void update(final Market observable)
	{
		// Bleurgh! but you get the idea...
		if (observable.getMarketType() == MarketType.USD_GBP)
		{
			latestDollarStirlingMarketBidPrice = observable.getLastBidPrice();
		}
		else if (observable.getMarketType() == MarketType.USD_EUR)
		{
			latestDollarEuroMarketBidPrice = observable.getLastBidPrice();
		}
	}
}
