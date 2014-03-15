package com.gazbert.patterns.creational.abstractfactory;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.account.PlatinumAccount;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.address.OffshoreAddress;
import com.gazbert.patterns.creational.abstractfactory.product.TaxExemptInvestmentFund;
import com.gazbert.patterns.creational.abstractfactory.product.Product;

/**
 * Concrete factory for creating our objects for the Offshore Investment Customer 'family'.
 *  
 * @author gazbert
 *
 */
public class OffshoreInvestmentCustomerFactory extends AbstractCustomerFactory {

    @Override
    public Address createAddress() {
	
	// my Bermuda address
	return new OffshoreAddress();
    }

    @Override
    public Account createAccount() {
	
	// offshore customers have special accounts
	return new PlatinumAccount();
    }

    @Override
    public Product createProduct() {
	
	// zarro capital gains... :-)
	return new TaxExemptInvestmentFund();
    }
}
