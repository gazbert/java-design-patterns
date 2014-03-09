package com.gazbert.patterns.creational.builder;

import com.gazbert.patterns.creational.builder.customer.Customer;

/**
 * The Abstract Builder provides all of the different buildXXX methods the Concrete Builders
 * <em>could</em> choose to build for creating a Customer.
 * <p>
 * Also provides a get Customer operations that Concrete Builders <em>must</em> honour.
 * 
 * @author gazbert
 *
 */
public abstract class AbstractCustomerBuilder {

    // all customers are built with these    
    public void buildContactDetails() {}    
    public void buildMarketingPreferences() {}    
    public void buildSalesOpportunities() {}        
    public void buildEmployerDetails() {}
    
    // below are 'optional' and not used to build all customers in this demo    
    public void buildRewardsScheme() {} // only investors have this
    public void buildCreditRatingReport() {} // only borrowers have this
    public void buildTaxationDetails() {} // only investors have this
    
    /**
     * Tells the Concrete Builder to return the Customer (Product) it has built up until now. 
     * @return the Customer that has been built.
     */
    public abstract Customer getCustomer();
}
