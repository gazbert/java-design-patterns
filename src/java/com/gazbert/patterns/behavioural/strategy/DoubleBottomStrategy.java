package com.gazbert.patterns.behavioural.strategy;

/*The MIT License (MIT)

Copyright (c) 2014 Gazbert

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

import java.math.BigDecimal;

/**
 * A Concrete Strategy impl.
 * 
 * @author gazbert
 *
 */
public class DoubleBottomStrategy implements TradingStrategy {

    @Override
    public void execute(final OrderBook orders) {

        System.out.println("Strategy Used: " + this.getClass().getSimpleName());	

        /*
         * Code goes in here to impl algo for deciding order to build using past trading history and what's
         * currently in the order book...
         *  
         * I'm just hard coding stuff for demo!
         */
        final Order orderToPlace = new ValidOrder(
                new BigDecimal(0.69), 
                new BigDecimal(100),
                new BigDecimal(69));

        // send order off to exchange...
    }
}
