package com.gazbert.patterns.creational.abstractfactory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.product.Product;

/**
 * Demonstrates use of Abstract Factory pattern.
 * 
 * @author gazbert
 *
 */
public class TestAbstractFactoryPattern 
{
    /** For sake of demo and id'ing what customer to create - the App business logic would decide this */
    private static enum CustomerType
    {
	OFFSHORE_INVESTOR,
	
	ONSHORE_INVESTOR;
    }
    
    /**
     * Some previous bit of code logic in the App decides we want to create an Offshore investment customer.
     */
    @Test
    public void testCreatingOffshoreInvesmentCustomer() throws Exception {
		
	// App logic decides this in real life...
	final CustomerType customerType = CustomerType.OFFSHORE_INVESTOR;
	
	final AbstractCustomerFactory abstractCustomeFactory;
	
	if (customerType == CustomerType.ONSHORE_INVESTOR)
	{
	    abstractCustomeFactory = new OnshoreInvestmentCustomerFactory();	    
	}
	else if (customerType == CustomerType.OFFSHORE_INVESTOR)
	{
	    abstractCustomeFactory = new OffshoreInvestmentCustomerFactory();
        }
	else
	{
	    throw new IllegalArgumentException("Unknown customer type: " + customerType);
	}
	
	// Create the Customer's parts - either and offshore investor or an onshore investor
	final Account account = abstractCustomeFactory.createAccount();
	final Address address = abstractCustomeFactory.createAddress();
	final Product product = abstractCustomeFactory.createProduct();
	
	// What we got?
	assertTrue(account.getAccountDetails().startsWith("Platinum"));
	assertTrue(address.getAddressDetails().startsWith("Offshore"));
	assertTrue(product.getProductDetails().startsWith("Investment Trust"));	
    }
    
    /**
     * Some previous bit of code logic in the App decides we want to create an Onshore investment customer.
     */
    @Test
    public void testCreatingOnshoreInvesmentCustomer() throws Exception {
		
	// App logic decides this in real life...
	final CustomerType customerType = CustomerType.ONSHORE_INVESTOR;
	
	final AbstractCustomerFactory abstractCustomeFactory;
	
	if (customerType == CustomerType.ONSHORE_INVESTOR)
	{
	    abstractCustomeFactory = new OnshoreInvestmentCustomerFactory();	    
	}
	else if (customerType == CustomerType.OFFSHORE_INVESTOR)
	{
	    abstractCustomeFactory = new OffshoreInvestmentCustomerFactory();
        }
	else
	{
	    throw new IllegalArgumentException("Unknown customer type: " + customerType);
	}
	
	// Create the Customer's parts - either and offshore investor or an onshore investor
	final Account account = abstractCustomeFactory.createAccount();
	final Address address = abstractCustomeFactory.createAddress();
	final Product product = abstractCustomeFactory.createProduct();
	
	// What we got?
	assertTrue(account.getAccountDetails().startsWith("Standard"));
	assertTrue(address.getAddressDetails().startsWith("Domicile"));
	assertTrue(product.getProductDetails().startsWith("Taxable OEIC"));	
    }
}
