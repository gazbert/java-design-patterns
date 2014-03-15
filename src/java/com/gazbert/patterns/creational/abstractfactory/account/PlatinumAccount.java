package com.gazbert.patterns.creational.abstractfactory.account;

/**
 * 
 * @author gazbert
 *
 */
public class PlatinumAccount implements Account {

    @Override
    public String getAccountDetails() {
	return "Platinum Account with lots of benefits";
    }

}
