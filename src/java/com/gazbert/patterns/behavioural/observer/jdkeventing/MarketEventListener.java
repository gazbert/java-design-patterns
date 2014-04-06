package com.gazbert.patterns.behavioural.observer.jdkeventing;

import java.util.EventListener;

/**
 * The market event listener our Observable (Market) implements.
 * <p>
 * EventListener is just a marker/tag interface like Serializable.
 * 
 * @author gazbert
 *
 */
public interface MarketEventListener extends EventListener
{
	/**
	 * All the Observers (bots) must implement this. 
	 * <p>
	 * This is the 'callback' for when bid price changes.
	 * 
	 * @param newBidPriceEvent the event with the latest bid price.
	 */
	public void onBidPriceUpdate(LatestMarketBidPriceEvent newBidPriceEvent);
}
