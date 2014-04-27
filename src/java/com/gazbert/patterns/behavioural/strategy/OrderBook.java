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

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Domain object for an Order Book.
 * <p>
 * This is a simple impl for purposes of demo'ing Strat pattern.
 * <p>
 * Order book is for FX USD <> GBP market only.
 * 
 * @author gazbert
 *
 */
public class OrderBook {
    
    private Map<UUID, ValidOrder> buyOrders;
    private Map<UUID, ValidOrder> sellOrders;

    public OrderBook()
    {
        buyOrders = new ConcurrentHashMap<UUID, ValidOrder>();
        sellOrders = new ConcurrentHashMap<UUID, ValidOrder>();
    }

    public void addBuyOrder(final ValidOrder order)
    {
        buyOrders.put(order.getOrderId(), order);
    }

    public Order getBuyOrder(final UUID orderId)
    {
        return buyOrders.get(orderId);
    }

    public void addSellOrder(final ValidOrder order)
    {
        sellOrders.put(order.getOrderId(), order);
    }

    public Order getSellOrder(final UUID orderId)
    {
        return sellOrders.get(orderId);
    }    
}
