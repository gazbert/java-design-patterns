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

import java.util.HashMap;
import java.util.Map;

import com.gazbert.patterns.behavioural.command.domain.Order;

/**
 * The Command Invoker.
 * <p>
 * This gets <em>parameterised</em> by the Client.
 * <p>
 * In this example, the invoker receives new orders off an exchange and then executes them.
 *
 * @author gazbert
 */
public class CommandInvoker {

    /**
     * Map of all our commands
     */
    private Map<String, OrderCommand> commands = new HashMap<>();

    /**
     * Sets the commands to invoke.
     * <p>
     * These are our trading order commands.
     *
     * @param id      the command Id
     * @param command the actual command to execute (later).
     */
    public void setCommand(String id, OrderCommand command) {
        commands.put(id, command);
    }

    /**
     * The 'business method' - we've received a new Order on the exchange.
     *
     * @param commandId the command id.
     * @param order the order.
     */
    public void onNewOrderCommand(String commandId, Order order) {
        // TODO pre-condition check to avoid NPE - is it in map?
        commands.get(commandId).execute(order);
    }
}
