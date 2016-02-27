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

package com.gazbert.patterns.behavioural.observer.jdkobserver;

import java.math.BigDecimal;
import java.util.Observable;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;

/**
 * This is the Observable.
 * <p>
 * Massively simplified. Use case is that whenever a new order goes in, we update the latest bid price, and notify all
 * bots of the price.
 * <p>
 * For production quality, this lot needs making thread safe etc...
 * <p>
 * Uses java.util.Observable - it cuts down on boiler-plate code. We could not use this approach if the Observable
 * already extended another class; lucky for us it doesn't.
 * <p>
 *
 * @author gazbert
 */
public abstract class Market extends Observable {
    /**
     * The market
     */
    private MarketType marketType;

    /**
     * The current/latest market bid price
     */
    private BigDecimal lastBidPrice;

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

        // tell java.util it's changed -calls up to superclass Observable
        setChanged();
        notifyObservers();
    }

    /**
     * Returns the last bid price.
     *
     * @return the last bid price
     */
    public BigDecimal getLastBidPrice() {
        return lastBidPrice;
    }

    /**
     * Returns the market being observed.
     *
     * @return thr market
     */
    public MarketType getMarketType() {
        return marketType;
    }
}