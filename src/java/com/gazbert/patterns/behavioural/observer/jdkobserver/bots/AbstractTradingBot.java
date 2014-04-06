package com.gazbert.patterns.behavioural.observer.jdkobserver.bots;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;
import com.gazbert.patterns.behavioural.observer.jdkobserver.Market;

/**
 * This would not exist in real world. Here because I'm too lazy to type same code for each bot.
 * <p>
 * Uses java.util.Observer.
 * <p>
 * 
 * @author gazbert
 *
 */
abstract class AbstractTradingBot implements Observer
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
	 * We let JDK do the work this time...
	 */
	@Override
	public void update(final Observable observable, final Object obj)
	{		
		final Market market = ((Market) observable);
		
		// Bleurgh! but you get the idea...
		if (market.getMarketType() == MarketType.USD_GBP)
		{
			latestUsdGbpMarketBidPrice = market.getLastBidPrice();
		}
		else if (market.getMarketType() == MarketType.USD_EUR)
		{
			latestUsdEurMarketBidPrice = market.getLastBidPrice();
		}
	}
}
