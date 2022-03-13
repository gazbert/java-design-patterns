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


package com.gazbert.patterns.behavioural.strategy;

/**
 * The Context. The trading bot uses this to make new orders based on the latest order book.
 * <p>
 * Clients uses this to execute trades.
 * <p>
 * Very simple impl only deals with USD to GBP market.
 * <p>
 *
 * @author gazbert
 */
public class TradingEngineContext {

    /**
     * The current strategy we are using
     */
    private TradingStrategy currentTradingStrategy;

    /**
     * Constructor defaults to a 'safe' support/resistance strategy.
     */
    public TradingEngineContext() {
        currentTradingStrategy = new SupportAndResistance();
    }

    /**
     * Returns the current trading strategy.
     *
     * @return trading strat
     */
    public TradingStrategy getCurrentTradingStrategy() {
        return currentTradingStrategy;
    }

    /**
     * Allows Clients to set the trading strategy.
     *
     * @param currentTradingStrategy trading strat
     */
    public void setCurrentTradingStrategy(TradingStrategy currentTradingStrategy) {
        this.currentTradingStrategy = currentTradingStrategy;
    }

    /**
     * Business method for client to call.
     * <p>
     * In our demo, the Client is the trading bot providing latest order book it fetched from the Exchange web service.
     * <p>
     * The business method sends a new order off to the exchange depending on the chosen trading strategy.
     *
     * @param latestOrderBook order book
     */
    public void createNewOrder(OrderBook latestOrderBook) {
        currentTradingStrategy.execute(latestOrderBook);
    }
}
