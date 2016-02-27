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

package com.gazbert.patterns.behavioural.command.receivers;

import com.gazbert.patterns.behavioural.command.domain.Order;

/**
 * A Receiver.
 * <p>
 * This is the Order Book. Massively simplified for the demo!
 * <p>
 *
 * @author gazbert
 */
public class OrderBook {

    public void updateBuyOrders(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - updating the Order Book BUY order: "
                + "id=" + order.getId()
                + " amount=" + order.getAmount()
                + " price= " + order.getPrice());
    }

    public void updateSellOrders(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - updating the Order Book SELL order: "
                + "id=" + order.getId()
                + "amount=" + order.getAmount()
                + " price= " + order.getPrice());
    }

    public void cancelOrder(Order order) {
        System.out.println(OrderBook.class.getSimpleName() + " - cancelling order for order:"
                + " id=" + order.getId()
                + " amount=" + order.getAmount());
    }
}
