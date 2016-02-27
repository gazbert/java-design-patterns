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
 * Null Object pattern (see separate design pattern) to indicate no order should be placed.
 * <p>
 * Avoids all the null checks... and NPEs being thrown
 *
 * @author gazbert
 */
public class NullOrder implements Order {

    /**
     * Just here for sake of demo
     */
    private String strategyUsed;


    @Override
    public BigDecimal getUsdPrice() {
        return new BigDecimal(0);
    }

    @Override
    public void setUsdPrice(BigDecimal usdPrice) {
        // TODO Auto-generated method stub	
    }

    @Override
    public BigDecimal getUsdAmount() {
        return new BigDecimal(0);
    }

    @Override
    public void setUsdAmount(BigDecimal usdAmount) {
        // TODO Auto-generated method stub	
    }

    @Override
    public BigDecimal getGbpAmount() {
        return new BigDecimal(0);
    }

    @Override
    public void setGbpAmount(BigDecimal gbpAmount) {
        // TODO Auto-generated method stub	
    }

    @Override
    public UUID getOrderId() {
        return UUID.randomUUID();
    }
}
