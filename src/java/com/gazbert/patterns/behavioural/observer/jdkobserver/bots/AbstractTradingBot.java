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
	 * We let Java do the work this time...
	 */
	@Override
	public void update(final Observable observable, final Object obj)
	{		
		final Market market = ((Market) observable);
		
		// Bleurgh! but you get the idea...
		if (market.getMarketType() == MarketType.USD_GBP)
		{
			latestDollarStirlingMarketBidPrice = market.getLastBidPrice();
		}
		else if (market.getMarketType() == MarketType.USD_EUR)
		{
			latestDollarEuroMarketBidPrice = market.getLastBidPrice();
		}
	}
}
