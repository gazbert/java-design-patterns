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

package com.gazbert.patterns.behavioural.visitor;

import java.math.BigDecimal;

/**
 * A domain class that represents a Trade in our class hierarchy/object graph.
 *
 * It is a Concrete Element and holds the Object Structure: it holds references to ALL objects that can be visited -
 * this allows us to iterate through and 'visit' them in the accept method.
 *
 * @author gazbert
 * @since 2016/02/27
 */
public abstract class AbstractTrade implements Trade { // Trade interface modified to extend Visitable

    private String currency;
    private BigDecimal price;

    private BuyOrder buyOrder;
    private SellOrder sellOrder;
    private TransactionFee fee;


    public AbstractTrade(String currency, BigDecimal amount) {

        this.currency = currency;
        this.price = amount;

        // do all existing functionality...
        buyOrder = new BuyOrder();
        sellOrder = new SellOrder();
        fee = new TransactionFee();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public TransactionFee getFee() {
        return fee;
    }

    /*
     * The new Visitor method. We iterate through the object graph/hierarchy to 'visit' them.
     */
    @Override
    public void accept(TradeVisitor visitor) {

        // visit each component first - this just sets the Visitor on each of Elements in our Trade object graph
        // - nothing happens yet...
        buyOrder.accept(visitor);
        sellOrder.accept(visitor);

        // then we visit the receiver - the double dispatch (callback on invoker) - this triggers the Visitor logic
        // on all of our Elements in the Trade object graph.
        visitor.visit(this);
    }

    public String toString() {
        return getClass().getName() + " : Price= " + this.getPrice();
    }
}
