package com.gazbert.patterns.behavioural.strategy;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents an order.
 * 
 * @author gazbert
 *
 */
interface Order {

    /**
     * Fetches ID of the order.
     * @return
     */
    UUID getOrderId();
    
    /**
     * Gets USD price.
     * @return
     */
    BigDecimal getUsdPrice();
    
    /**
     * Sets USD price.
     * @param usdPrice
     */
    void setUsdPrice(BigDecimal usdPrice);

    /**
     * Gets amount of USD to trade.
     * @return
     */
    BigDecimal getUsdAmount();
    
    /**
     * Sets amount of USD to trade.
     * @param usdAmount
     */
    void setUsdAmount(BigDecimal usdAmount);

    /**
     * Gets amount of GBP to trade.
     * @return
     */
    BigDecimal getGbpAmount();
    
    /**
     * Sets amount of GBP to trade.
     * @param gbpAmount
     */
    void setGbpAmount(BigDecimal gbpAmount);
}