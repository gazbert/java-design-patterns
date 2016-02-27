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

package com.gazbert.patterns.behavioural.command.commands;

import com.gazbert.patterns.behavioural.command.OrderCommand;
import com.gazbert.patterns.behavioural.command.domain.Order;
import com.gazbert.patterns.behavioural.command.receivers.OrderBook;

/**
 * Concrete Command for placing a SELL order.
 *
 * @author gazbert
 */
public class OrderBookSellCommand implements OrderCommand {

    /**
     * The Order Book is the receiver
     */
    private OrderBook orderBook;


    /**
     * Constructs the command with the Recevier.
     *
     * @param orderBook the receiver the command will perform operations on.
     */
    public OrderBookSellCommand(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void execute(Order order) {
        orderBook.updateSellOrders(order);
    }
}
