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
	 * @param observable the Observable/Subject is passed to the Observer to it can get at the changed state.
	 */
	public void update(Market observable);
}
