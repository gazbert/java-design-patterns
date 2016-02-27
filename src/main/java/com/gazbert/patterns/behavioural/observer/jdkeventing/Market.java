/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.patterns.behavioural.observer.jdkeventing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Observable.
 * <p>
 * Massively simplified. Use case is that whenever a new order goes in, we update the latest bid price, and notify all
 * bots of the price.
 * <p>
 * For production quality, this stuff needs making thread safe etc...
 * <p>
 *
 * @author gazbert
 */
public abstract class Market {

    /**
     * The current/latest market bid price
     */
    private BigDecimal lastBidPrice;

    /**
     * The market
     */
    private MarketType marketType;

    /**
     * The observers interested in the price changes
     */
    private List<MarketEventListener> priceObservers;

    /**
     * Constructor initialises our list for storing Observers.
     */
    public Market() {
        priceObservers = new ArrayList<>();
    }

    /**
     * Register an Observer.
     *
     * @param observer the interested observer.
     */
    public void registerPriceObserver(MarketEventListener observer) {
        priceObservers.add(observer);
    }

    /**
     * Unregister an Observer.
     *
     * @param observer the interested observer.
     */
    public void unregisterPriceObserver(MarketEventListener observer) {
        priceObservers.remove(observer);
    }

    /**
     * Notifies all Observers of a change.
     * <p>
     * TODO - this is often public/protected in lots of other examples I've seen - why??? Surely better to control
     * access to this so that Observers are only notified via this class' business methods i.e. createNewBuyOrder?
     */
    private void notifyObservers() {
        // Build the event
        final LatestMarketBidPriceEvent latestBidPriceEvent = new LatestMarketBidPriceEvent(this, lastBidPrice,
                marketType);

        // Notify interested parties...
        for (final MarketEventListener anObserver : priceObservers) {
            anObserver.onBidPriceUpdate(latestBidPriceEvent);
        }
    }

    ///////////////////// Business state that when changes, triggers updates ////////////////////////

    /**
     * In real life a proper order would come in here, not just the bid price. Keeping it simple...
     *
     * @param lastBidPrice new price
     * @param marketType   the market we're trading on
     */
    public void createNewBuyOrder(BigDecimal lastBidPrice, MarketType marketType) {
        this.lastBidPrice = lastBidPrice;
        this.marketType = marketType;
        notifyObservers();
    }
}