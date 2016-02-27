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

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.gazbert.patterns.behavioural.observer.jdkeventing.bots.BoATradingBot;
import com.gazbert.patterns.behavioural.observer.jdkeventing.bots.GoldmanTradingBot;
import com.gazbert.patterns.behavioural.observer.jdkeventing.bots.HsbcTradingBot;

/**
 * Demonstrates use of Observer pattern using java.util.EventObject.
 * <p>
 * Use when you cannot use java.util.Observerable because your Observable/Subject already extends another class.
 * <p>
 *
 * @author gazbert
 */
public class TestEventingObserverPattern {
    /**
     * Tests USD GBP market observer.
     */
    @Test
    public void testUsdGbpMarketObserver() {

        // Different banks create their bots, and register with exchange for latest market bid price
        final GoldmanTradingBot goldman = new GoldmanTradingBot();
        DollarSterlingMarket.getInstance().registerPriceObserver(goldman);

        final HsbcTradingBot hsbc = new HsbcTradingBot();
        DollarSterlingMarket.getInstance().registerPriceObserver(hsbc);

        final BoATradingBot boa = new BoATradingBot();
        // BoA bot is taking the day off... ;-)
        //DollarStirlingMarketTradePrice.getInstance().registerPriceObserver(boa);

        // Assert current price from previous day's close
        final BigDecimal yesterdaysBidPrice = new BigDecimal("0.60");
        assertTrue(yesterdaysBidPrice.compareTo(goldman.getLatestUsdGbpMarketBidPrice()) == 0);
        assertTrue(yesterdaysBidPrice.compareTo(hsbc.getLatestUsdGbpMarketBidPrice()) == 0);
        assertTrue(yesterdaysBidPrice.compareTo(boa.getLatestUsdGbpMarketBidPrice()) == 0);

        // A trade occurs on the exchange, so it notifies any observers of latest market bid price...
        final BigDecimal newBidPrice = new BigDecimal("0.61");

        // In real life, this would come from a proper buy order - I'm just using a bid price to keep it simple!
        DollarSterlingMarket.getInstance().createNewBuyOrder(newBidPrice, MarketType.USD_GBP);

        // Did they get price update? 
        assertTrue(newBidPrice.compareTo(goldman.getLatestUsdGbpMarketBidPrice()) == 0);
        assertTrue(newBidPrice.compareTo(hsbc.getLatestUsdGbpMarketBidPrice()) == 0);

        // No change from yesterday
        assertTrue(yesterdaysBidPrice.compareTo(boa.getLatestUsdGbpMarketBidPrice()) == 0);

        // Markets close for the day; bots head out for some much needed Krug...
        DollarSterlingMarket.getInstance().unregisterPriceObserver(goldman);
        DollarSterlingMarket.getInstance().unregisterPriceObserver(hsbc);
    }

    /**
     * Tests USD EUR market observer.
     */
    @Test
    public void testUsdEurMarketObserver() {

        // Different banks create their bots, and register with exchange for latest market bid price
        final GoldmanTradingBot goldman = new GoldmanTradingBot();
        DollarEuroMarket.getInstance().registerPriceObserver(goldman);

        final HsbcTradingBot hsbc = new HsbcTradingBot();
        DollarEuroMarket.getInstance().registerPriceObserver(hsbc);

        final BoATradingBot boa = new BoATradingBot();
        // BoA bot is taking the day off... ;-)
        //DollarStirlingMarketTradePrice.getInstance().registerPriceObserver(boa);

        // Assert current price from previous day's close
        final BigDecimal yesterdaysBidPrice = new BigDecimal("0.73");
        assertTrue(yesterdaysBidPrice.compareTo(goldman.getLatestUsdEuroMarketBidPrice()) == 0);
        assertTrue(yesterdaysBidPrice.compareTo(hsbc.getLatestUsdEuroMarketBidPrice()) == 0);
        assertTrue(yesterdaysBidPrice.compareTo(boa.getLatestUsdEuroMarketBidPrice()) == 0);

        // A trade occurs on the exchange, so it notifies any observers of latest market bid price...
        final BigDecimal newBidPrice = new BigDecimal("0.74");

        // In real life, this would come from a proper buy order - I'm just using a bid price to keep it simple!
        DollarEuroMarket.getInstance().createNewBuyOrder(newBidPrice, MarketType.USD_EUR);

        // Did they get price update? 
        assertTrue(newBidPrice.compareTo(goldman.getLatestUsdEuroMarketBidPrice()) == 0);
        assertTrue(newBidPrice.compareTo(hsbc.getLatestUsdEuroMarketBidPrice()) == 0);

        // No change from yesterday
        assertTrue(yesterdaysBidPrice.compareTo(boa.getLatestUsdEuroMarketBidPrice()) == 0);

        // Markets close for the day; bots head out for some much needed Krug...
        DollarEuroMarket.getInstance().unregisterPriceObserver(goldman);
        DollarEuroMarket.getInstance().unregisterPriceObserver(hsbc);
    }
}
