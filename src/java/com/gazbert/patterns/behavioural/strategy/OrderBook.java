package com.gazbert.patterns.behavioural.strategy;

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
