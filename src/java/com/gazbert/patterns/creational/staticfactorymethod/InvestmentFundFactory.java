package com.gazbert.patterns.creational.staticfactorymethod;

import com.gazbert.patterns.creational.factorymethod.products.Gilt;
import com.gazbert.patterns.creational.factorymethod.products.InvestmentTrust;
import com.gazbert.patterns.creational.factorymethod.products.Oeic;
import com.gazbert.patterns.creational.factorymethod.products.Product;

/**
 * This is the abstract factory the Client code uses to build different Product types.
 * <p>
 * It is a <em>simple</em> factory that contains a <em>static</em> factory method.
 * <p>
 * The 'factory method' is not abstract like in the traditional Factory Method pattern; it builds/instantiates
 * the actual Product objects. It eliminates the need for creating separate Concrete Factory subclass impls.
 * <p>
 * Clients use this static factory method directly.
 * 
 * @author gazbert
 *
 */
public abstract class InvestmentFundFactory {
    
    /** Some sample financial investment products for purposes of the demo */
    public enum ProductType 
    {
	OEIC, 
	GILT,
	INVESTMENT_TRUST,
	CASH_SAVINGS_ACCOUNT,
	GUARANTEED_INCOME_BOND
    };

    /**
     * This is the business method for the Client code to call to create Products.
     * <p>
     * This is also the static 'Factory Method' that builds the Products. Clients call this directly.
     * <p>
     * FYI: An ISA (individual Savings Account) is a tax free investment vehicle used in the UK.
     * 
     * @param forUseInAnIsa true is this is used in an ISA, false otherwise.
     * @param productType the Product type to build.
     * @return the built Product.
     */
    public static Product build(boolean forUseInAnIsa, final ProductType productType)
    {	
	final Product product;
	
	if (productType == ProductType.GILT)
	{
	    product = new Gilt();
	}
	else if (productType == ProductType.OEIC)
	{
	    product = new Oeic();
	}
	else if (productType == ProductType.INVESTMENT_TRUST)
	{
	    product = new InvestmentTrust();
	}
	else
	{
	    throw new IllegalArgumentException("Can't build unknown productType: " + productType);
	}
	
	product.setIsTaxable(!forUseInAnIsa);	
	return product;
    }
}
