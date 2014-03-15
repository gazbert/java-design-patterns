package com.gazbert.patterns.creational.abstractfactory;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.account.StandardAccount;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.address.DomicileAddress;
import com.gazbert.patterns.creational.abstractfactory.product.Product;
import com.gazbert.patterns.creational.abstractfactory.product.TaxableInvestmentFund;

/**
 * Concrete factory for creating our objects for the Onshore Investment Customer 'family'.
 *  
 * @author gazbert
 *
 */
public class OnshoreInvestmentCustomerFactory extends AbstractCustomerFactory {

    @Override
    public Address createAddress() {
	
	// UK address
	return new DomicileAddress();
    }

    @Override
    public Account createAccount() {
	
	// onshore customers have standard accounts
	return new StandardAccount();
    }

    @Override
    public Product createProduct() {
	
	// and they're taxed
	return new TaxableInvestmentFund();
    }
}
