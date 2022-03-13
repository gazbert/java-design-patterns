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
 * Domain object for an Order.
 * <p>
 * This is a simple impl for purposes of demo'ing Strat pattern.
 * <p>
 * Order is for FX trading of US dollar to GB pound market.
 *
 * @author gazbert
 */
public class ValidOrder implements Order {

    /**
     * Id
     */
    private UUID orderId;

    /**
     * US dollar (strike) price e.g. 0.69
     */
    private BigDecimal usdPrice;

    /**
     * Amount of USD to trade
     */
    private BigDecimal usdAmount;

    /**
     * Amount of GBP to trade
     */
    private BigDecimal gbpAmount;


    /**
     * Builds the order.
     *
     * @param usdPrice USD price
     * @param usdAmount USD amount
     * @param gbpAmount GBP amount
     */
    public ValidOrder(BigDecimal usdPrice, BigDecimal usdAmount, BigDecimal gbpAmount) {
        this.usdPrice = usdPrice;
        this.usdAmount = usdAmount;
        this.gbpAmount = gbpAmount;

        this.orderId = UUID.randomUUID();
    }

    @Override
    public BigDecimal getUsdPrice() {
        return usdPrice;
    }

    @Override
    public void setUsdPrice(final BigDecimal usdPrice) {
        this.usdPrice = usdPrice;
    }

    @Override
    public BigDecimal getUsdAmount() {
        return usdAmount;
    }

    @Override
    public void setUsdAmount(final BigDecimal usdAmount) {
        this.usdAmount = usdAmount;
    }

    @Override
    public BigDecimal getGbpAmount() {
        return gbpAmount;
    }

    @Override
    public void setGbpAmount(final BigDecimal gbpAmount) {
        this.gbpAmount = gbpAmount;
    }

    @Override
    public UUID getOrderId() {
        return orderId;
    }
}
