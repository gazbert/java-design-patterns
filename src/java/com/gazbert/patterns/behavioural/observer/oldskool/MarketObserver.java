package com.gazbert.patterns.behavioural.observer.oldskool;


/**
 * The Observer interface all Clients (Observers) must implement to receive price updates.
 * 
 * @author gazbert
 *
 */
public interface MarketObserver
{
	/**
	 * Called by the Subject to inform Clients (Observers) of price change.
	 * 
	 * @param observable the observable/subject.
	 */
	public void update(Market observable);
}
