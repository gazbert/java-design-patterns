package com.gazbert.patterns.behavioural.command.domain;

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
 * Domain class for an order received on the exchange. Not part of the Command pattern per se.
 * <p>
 * Kept simple for the demo!
 * <p>
 * @author gazbert
 *
 */
public class Order
{    
    private long id;
    private BigDecimal amount;    
    private BigDecimal price;
  
    
    /**
     * Constructor builds an order.
     * @param id
     * @param amount
     * @param price
     */
    public Order(final long id, final BigDecimal amount, final BigDecimal price)
    {
        this.id = id;
        this.amount = price;    
        this.price = price;
    }

    public long getId()
    {
        return id;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
}
