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

import org.junit.Test;

/**
 * Demonstrates use of Strategy pattern.
 * <p>
 * I'm using a trading bot as an example here.
 * <p>
 * Scenario is the bot has just made a web service call to the FX exchange to get the latest order book for a given
 * market.  Only using 1 market for the demo: USD <> GBP.
 * <p>
 * To demo the Strategy pattern, the bot is going to use the trading engine context to get next order (if indeed there
 * is one) it needs to place on the FX exchange.
 * <p>
 * In real-world, the current order book and past trading history would be interpreted/analysed to
 * determine which trading strategy to use; the Interpreter pattern would be useful here.
 * <p>
 * TODO - assert something!
 * <p>
 *
 * @author gazbert
 */
public class TestStategyPattern {
    /**
     * Bot has recognised a double bottom pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDoubleBottomStrategy() {

        // The latest Order Book fetched from the exchange. 
        final OrderBook latestOrders = new OrderBook();

        // Create the Context
        final TradingEngineContext tradingEngineCtx = new TradingEngineContext();

        // Select the strategy
        tradingEngineCtx.setCurrentTradingStrategy(new DoubleBottomStrategy());

        // Create the order and send off to exchange
        tradingEngineCtx.createNewOrder(latestOrders);
    }

    /**
     * Bot has recognised a head n shoulders pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingHeadAndShouldersStrategy() {

        // The latest Order Book fetched from the exchange. 
        final OrderBook latestOrders = new OrderBook();

        // Create the Context
        final TradingEngineContext tradingEngineCtx = new TradingEngineContext();

        // Select the strategy
        tradingEngineCtx.setCurrentTradingStrategy(new HeadAndShoulders());

        // Create the order and send off to exchange
        tradingEngineCtx.createNewOrder(latestOrders);
    }

    /**
     * Bot has recognised a double top pattern pattern; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDoubleTopStrategy() {

        // The latest Order Book fetched from the exchange. 
        final OrderBook latestOrders = new OrderBook();

        // Create the Context
        final TradingEngineContext tradingEngineCtx = new TradingEngineContext();

        // Select the strategy
        tradingEngineCtx.setCurrentTradingStrategy(new DoubleTopStrategy());

        // Create the order and send off to exchange
        tradingEngineCtx.createNewOrder(latestOrders);
    }

    /**
     * Bot using default strat; build an order using this strategy...
     */
    @Test
    public void testTradingUsingDefaultStrategy() {

        // The latest Order Book fetched from the exchange. 
        final OrderBook latestOrders = new OrderBook();

        // Create the Context
        final TradingEngineContext tradingEngineCtx = new TradingEngineContext();

        // Using default strategy	
        // Create the order and send off to exchange
        tradingEngineCtx.createNewOrder(latestOrders);
    }
}
