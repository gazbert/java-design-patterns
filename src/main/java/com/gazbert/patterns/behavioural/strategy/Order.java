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

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents an order.
 *
 * @author gazbert
 */
interface Order {

    /**
     * Fetches ID of the order.
     *
     * @return
     */
    UUID getOrderId();

    /**
     * Gets USD price.
     *
     * @return
     */
    BigDecimal getUsdPrice();

    /**
     * Sets USD price.
     *
     * @param usdPrice
     */
    void setUsdPrice(BigDecimal usdPrice);

    /**
     * Gets amount of USD to trade.
     *
     * @return
     */
    BigDecimal getUsdAmount();

    /**
     * Sets amount of USD to trade.
     *
     * @param usdAmount
     */
    void setUsdAmount(BigDecimal usdAmount);

    /**
     * Gets amount of GBP to trade.
     *
     * @return
     */
    BigDecimal getGbpAmount();

    /**
     * Sets amount of GBP to trade.
     *
     * @param gbpAmount
     */
    void setGbpAmount(BigDecimal gbpAmount);
}