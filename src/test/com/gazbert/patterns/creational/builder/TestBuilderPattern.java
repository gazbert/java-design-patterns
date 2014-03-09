package com.gazbert.patterns.creational.builder;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.gazbert.patterns.creational.builder.account.PlatinumAccount;
import com.gazbert.patterns.creational.builder.account.StandardAccount;
import com.gazbert.patterns.creational.builder.customer.BorrowingCustomer;
import com.gazbert.patterns.creational.builder.customer.Customer;
import com.gazbert.patterns.creational.builder.customer.InvestingCustomer;
import com.gazbert.patterns.creational.builder.customer.LoanCustomer;
import com.gazbert.patterns.creational.builder.customer.MortgageCustomer;
import com.gazbert.patterns.creational.builder.customer.SavingsCustomer;
import com.gazbert.patterns.creational.builder.customer.StockbrokingCustomer;

/**
 * Demonstrates use of Builder pattern.
 * <p>
 * Simple usage pattern only - the actual test asserts are crap!
 * 
 * @author gazbert
 *
 */
public class TestBuilderPattern 
{
    @Test
    public void testBuildingSavingsCustomer() {
	
	final InvestingCustomer investingCustomer = new SavingsCustomer(new StandardAccount(new BigDecimal(7000)));
	final AbstractCustomerBuilder customerBuilder = new InvestingCustomerBuilder(investingCustomer);
	final AbstractCustomerDirector investorDirector = new InvestingCustomerDirector();
	final Customer customer = investorDirector.build(customerBuilder);
	
	assertTrue(customer instanceof SavingsCustomer);
	System.out.println(customer);
	System.out.println();
    }
    
    @Test
    public void testBuildingStockbrokingCustomer() {
	
	final InvestingCustomer investingCustomer = new StockbrokingCustomer(new PlatinumAccount(new BigDecimal(10000000)));
	final AbstractCustomerBuilder customerBuilder = new InvestingCustomerBuilder(investingCustomer);
	final AbstractCustomerDirector investorDirector = new InvestingCustomerDirector();
	final Customer customer = investorDirector.build(customerBuilder);
	
	assertTrue(customer instanceof StockbrokingCustomer);
	System.out.println(customer);
	System.out.println();
    }
    
    @Test
    public void testBuildingMortgageCustomer() {
	
	final BorrowingCustomer borrowingCustomer = new MortgageCustomer(new PlatinumAccount(new BigDecimal(500000)));
	final AbstractCustomerBuilder customerBuilder = new BorrowingCustomerBuilder(borrowingCustomer);
	final AbstractCustomerDirector borrowingDirector = new BorrowingCustomerDirector();
	final Customer customer = borrowingDirector.build(customerBuilder);
	
	assertTrue(customer instanceof MortgageCustomer);
	System.out.println(customer);
	System.out.println();
    }    
    
    @Test
    public void testBuildingLoanCustomer() {
	
	final BorrowingCustomer borrowingCustomer = new LoanCustomer(new StandardAccount(new BigDecimal(5000)));
	final AbstractCustomerBuilder customerBuilder = new BorrowingCustomerBuilder(borrowingCustomer);
	final AbstractCustomerDirector borrowingDirector = new BorrowingCustomerDirector();
	final Customer customer = borrowingDirector.build(customerBuilder);
	
	assertTrue(customer instanceof LoanCustomer);
	System.out.println(customer);
    }
}
