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

package com.gazbert.patterns.behavioural.command;

import java.math.BigDecimal;

import org.junit.Test;

import com.gazbert.patterns.behavioural.command.commands.OrderBookBuyCommand;
import com.gazbert.patterns.behavioural.command.commands.OrderBookCancelCommand;
import com.gazbert.patterns.behavioural.command.commands.OrderBookSellCommand;
import com.gazbert.patterns.behavioural.command.commands.RegulateBuyOrderCommand;
import com.gazbert.patterns.behavioural.command.commands.RegulateSellOrderCommand;
import com.gazbert.patterns.behavioural.command.domain.Order;
import com.gazbert.patterns.behavioural.command.receivers.OrderBook;
import com.gazbert.patterns.behavioural.command.receivers.RegulatorySystem;

/**
 * Demonstrates use of Command pattern.
 *
 * @author gazbert
 */
public class TestCommandPattern {

    // These would live elsewhere in a proper command dictionary in real life...
    private static String ORDERBOOK_SELL_COMMAND = "orderbook-sell";
    private static String ORDERBOOK_BUY_COMMAND = "orderbook-buy";
    private static String ORDERBOOK_CANCEL_COMMAND = "orderbook-cancel";

    private static String REGULATE_SELL_COMMAND = "regulate-sell";
    private static String REGULATE_BUY_COMMAND = "regulate-buy";


    /**
     * TODO change test to actually assert something!
     */
    @Test
    public void testCommandPattern() {
        // System starts up....

        // Create the Receivers
        final OrderBook orderBook = new OrderBook();
        final RegulatorySystem regulatorySystem = new RegulatorySystem();

        // Create some order book commands
        final OrderCommand removeFromOrderBook = new OrderBookCancelCommand(orderBook);
        final OrderCommand addBuyToOrderBook = new OrderBookBuyCommand(orderBook);
        final OrderCommand addSellToOrderBook = new OrderBookSellCommand(orderBook);

        // Create some reulatory system commands        
        final OrderCommand regulateBuyOrder = new RegulateBuyOrderCommand(regulatorySystem);
        final OrderCommand regulateSellOrder = new RegulateSellOrderCommand(regulatorySystem);

        // Create and parameterise the invoker for the Order Book
        final CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.setCommand(ORDERBOOK_BUY_COMMAND, addBuyToOrderBook);
        commandInvoker.setCommand(ORDERBOOK_CANCEL_COMMAND, removeFromOrderBook);
        commandInvoker.setCommand(ORDERBOOK_SELL_COMMAND, addSellToOrderBook);

        // System up and initialised. Wait for orders to come in off exchange...

        // Process order book first
        final Order buyOrder = new Order(123, new BigDecimal("100"), new BigDecimal("1.45"));
        final Order sellOrder = new Order(999, new BigDecimal("200"), new BigDecimal("2.45"));
        final Order cancelOrder = new Order(777, new BigDecimal("300"), new BigDecimal("3.45"));

        commandInvoker.onNewOrderCommand(ORDERBOOK_BUY_COMMAND, buyOrder);
        commandInvoker.onNewOrderCommand(ORDERBOOK_SELL_COMMAND, sellOrder);
        commandInvoker.onNewOrderCommand(ORDERBOOK_CANCEL_COMMAND, cancelOrder);

        // Now set the SAME Command Invoker to use the Regulatory system to regulate the buy/sell orders
        // i.e. we parameterise it with the reg system
        commandInvoker.setCommand(REGULATE_BUY_COMMAND, regulateBuyOrder);
        commandInvoker.setCommand(REGULATE_SELL_COMMAND, regulateSellOrder);

        commandInvoker.onNewOrderCommand(REGULATE_BUY_COMMAND, buyOrder);
        commandInvoker.onNewOrderCommand(REGULATE_SELL_COMMAND, sellOrder);
        // there is no regulate for a cancel order; who cares right?

    }
}
