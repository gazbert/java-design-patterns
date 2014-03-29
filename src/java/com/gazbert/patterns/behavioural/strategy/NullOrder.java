package com.gazbert.patterns.behavioural.strategy;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Null Object pattern (see separate design pattern) to indicate no order should be placed.
 * <p>
 * Avoids all the null checks... and NPEs being thrown
 * 
 * @author gazbert
 *
 */
public class NullOrder implements Order {

    /** Just here for sake of demo */
    private String strategyUsed;
    
    
    @Override
    public BigDecimal getUsdPrice() {
	return new BigDecimal(0);
    }

    @Override
    public void setUsdPrice(BigDecimal usdPrice) {
	// TODO Auto-generated method stub	
    }

    @Override
    public BigDecimal getUsdAmount() {
	return new BigDecimal(0);
    }

    @Override
    public void setUsdAmount(BigDecimal usdAmount) {
	// TODO Auto-generated method stub	
    }

    @Override
    public BigDecimal getGbpAmount() {
	return new BigDecimal(0);
    }

    @Override
    public void setGbpAmount(BigDecimal gbpAmount) {
	// TODO Auto-generated method stub	
    }

    @Override
    public UUID getOrderId() {
	return UUID.randomUUID();
    }

    ///// just for demo so we can show how diff strats are used in unit test /////
    
    @Override
    public String getStrategyUsed() {
        return strategyUsed;
    }

    @Override
    public void setStrategyUsed(String strategyUsed) {
        this.strategyUsed = strategyUsed;
    }  
}
