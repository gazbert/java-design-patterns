package com.gazbert.patterns.behavioural.observer.oldskool;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.gazbert.patterns.behavioural.observer.jdkeventing.MarketType;
import com.gazbert.patterns.behavioural.observer.oldskool.DollarStirlingMarket;
import com.gazbert.patterns.behavioural.observer.oldskool.bots.BoATradingBot;
import com.gazbert.patterns.behavioural.observer.oldskool.bots.GoldmanTradingBot;
import com.gazbert.patterns.behavioural.observer.oldskool.bots.HsbcTradingBot;

/**
 * Demonstrates use of Observer pattern from scratch. 
 * <p>
 * Use when you cannot use java.util.Observer because your Observable/Subject needs to extend another class.
 * <p>
 * @author gazbert
 *
 */
public class TestOldSkoolObserverPattern 
{
    /**
     * Test USD GBP market observer.
     */
    @Test
    public void testUsdGbpMarketObserver() {
    	
    	// Different banks create their bots, and register with exchange for latest market bid price
        final GoldmanTradingBot goldman = new GoldmanTradingBot();
       	DollarStirlingMarket.getInstance().registerPriceOberver(goldman);                
        
        final HsbcTradingBot hsbc = new HsbcTradingBot();
       	DollarStirlingMarket.getInstance().registerPriceOberver(hsbc);        
       	
        final BoATradingBot boa = new BoATradingBot();
        // BoA bot is taking the day off... ;-)
       	//DollarStirlingMarketTradePrice.getInstance().registerPriceOberver(boa);                       

        // Assert current price from previous day's close
        final BigDecimal yesterdaysPrice = new BigDecimal(0.60);
        assertTrue(yesterdaysPrice.compareTo(goldman.getLatestDollarStirlingMarketBidPrice()) == 0);
        assertTrue(yesterdaysPrice.compareTo(hsbc.getLatestDollarStirlingMarketBidPrice()) == 0);
        assertTrue(yesterdaysPrice.compareTo(boa.getLatestDollarStirlingMarketBidPrice()) == 0);
        
        // A trade occurs on the exchange, so it notifies any observers of latest market bid price...
        final BigDecimal newPrice = new BigDecimal(0.61);
        
        // In real life, this would come from a proper buy order - I'm just using a bid price to keep it simple!
    	DollarStirlingMarket.getInstance().createNewBuyOrder(newPrice, MarketType.USD_GBP);
        
        // Did they get price update? 
        assertTrue(newPrice.compareTo(goldman.getLatestDollarStirlingMarketBidPrice()) == 0);
        assertTrue(newPrice.compareTo(hsbc.getLatestDollarStirlingMarketBidPrice()) == 0);
        
        // No change from yesterday
        assertTrue(yesterdaysPrice.compareTo(boa.getLatestDollarStirlingMarketBidPrice()) == 0);
        
        // Markets close for the day; bots head out for some much needed Krug...
    	DollarStirlingMarket.getInstance().unregisterPriceOberver(goldman);    	
    	DollarStirlingMarket.getInstance().unregisterPriceOberver(hsbc);  
    }		
    
    /**
     * Test USD EUR market observer.
     */
    @Test
    public void testUsdEurMarketObserver() {
    	
    	// Different banks create their bots, and register with exchange for latest market bid price
        final GoldmanTradingBot goldman = new GoldmanTradingBot();
        DollarEuroMarket.getInstance().registerPriceOberver(goldman);                
        
        final HsbcTradingBot hsbc = new HsbcTradingBot();
        DollarEuroMarket.getInstance().registerPriceOberver(hsbc);        
       	
        final BoATradingBot boa = new BoATradingBot();
        // BoA bot is taking the day off... ;-)
       	//DollarStirlingMarketTradePrice.getInstance().registerPriceOberver(boa);                       

        // Assert current price from previous day's close
        final BigDecimal yesterdaysPrice = new BigDecimal(0.73);
        assertTrue(yesterdaysPrice.compareTo(goldman.getLatestDollarEuroMarketBidPrice()) == 0);
        assertTrue(yesterdaysPrice.compareTo(hsbc.getLatestDollarEuroMarketBidPrice()) == 0);
        assertTrue(yesterdaysPrice.compareTo(boa.getLatestDollarEuroMarketBidPrice()) == 0);
        
        // A trade occurs on the exchange, so it notifies any observers of latest market bid price...
        final BigDecimal newPrice = new BigDecimal(0.61);
        
        // In real life, this would come from a proper buy order - I'm just using a bid price to keep it simple!
        DollarEuroMarket.getInstance().createNewBuyOrder(newPrice, MarketType.USD_EUR);
        
        // Did they get price update? 
        assertTrue(newPrice.compareTo(goldman.getLatestDollarEuroMarketBidPrice()) == 0);
        assertTrue(newPrice.compareTo(hsbc.getLatestDollarEuroMarketBidPrice()) == 0);
        
        // No change from yesterday
        assertTrue(yesterdaysPrice.compareTo(boa.getLatestDollarEuroMarketBidPrice()) == 0);
        
        // Markets close for the day; bots head out for some much needed Krug...
        DollarEuroMarket.getInstance().unregisterPriceOberver(goldman);    	
        DollarEuroMarket.getInstance().unregisterPriceOberver(hsbc);  
    }	
}
