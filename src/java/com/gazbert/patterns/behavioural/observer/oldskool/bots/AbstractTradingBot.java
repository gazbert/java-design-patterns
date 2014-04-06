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
	private BigDecimal latestUsdGbpMarketBidPrice = new BigDecimal(0.60);
	
	/** USD EUR market bid price */
	private BigDecimal latestUsdEurMarketBidPrice = new BigDecimal(0.73);
	
	
	public BigDecimal getLatestUsdGbpMarketBidPrice()
	{
		return latestUsdGbpMarketBidPrice;
	}
	
	public BigDecimal getLatestUsdEurMarketBidPrice()
	{
		return latestUsdEurMarketBidPrice;
	}
	
	/**
	 * The callback when stuff on the Observable (Subject) has been updated.
	 * 
	 * @param observable the Observable (Subject) is passed in the update method for Observer to get at the changed 
	 *                   state.
	 */
	@Override
	public void update(final Market observable)
	{
		// Bleurgh! but you get the idea...
		if (observable.getMarketType() == MarketType.USD_GBP)
		{
			latestUsdGbpMarketBidPrice = observable.getLastBidPrice();
		}
		else if (observable.getMarketType() == MarketType.USD_EUR)
		{
			latestUsdEurMarketBidPrice = observable.getLastBidPrice();
		}
	}
}
