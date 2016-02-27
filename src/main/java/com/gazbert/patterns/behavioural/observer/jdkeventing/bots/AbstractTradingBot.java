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

package com.gazbert.patterns.behavioural.observer.jdkeventing.bots;

import java.math.BigDecimal;

import com.gazbert.patterns.behavioural.observer.jdkeventing.LatestMarketBidPriceEvent;
import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketEventListener;
import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;

/**
 * This would not exist in real world. Here because I'm too lazy to type same code for each bot...
 * <p>
 * Implements #{link MarketEventListener} to receive price updates...
 * <p>
 *
 * @author gazbert
 */
abstract class AbstractTradingBot implements MarketEventListener {

    /**
     * USD GBP market bid price
     */
    private BigDecimal latestUsdGbpMarketBidPrice = new BigDecimal("0.60");

    /**
     * USD EUR market bid price
     */
    private BigDecimal latestUsdEurMarketBidPrice = new BigDecimal("0.73");


    public BigDecimal getLatestUsdGbpMarketBidPrice() {
        return latestUsdGbpMarketBidPrice;
    }

    public BigDecimal getLatestUsdEuroMarketBidPrice() {
        return latestUsdEurMarketBidPrice;
    }


    /**
     * This is the callback for when price changes...
     */
    @Override
    public void onBidPriceUpdate(final LatestMarketBidPriceEvent newBidPriceEvent) {
        // Bleurgh! but you get the idea...
        if (newBidPriceEvent.getMarketType() == MarketType.USD_GBP) {
            latestUsdGbpMarketBidPrice = newBidPriceEvent.getLatestBidPrice();
        } else if (newBidPriceEvent.getMarketType() == MarketType.USD_EUR) {
            latestUsdEurMarketBidPrice = newBidPriceEvent.getLatestBidPrice();
        }
    }
}
