package com.gazbert.patterns.creational.factorymethod.products;

/**
 * The Product interface for all product types.
 * <p>
 * Massively simplified for the demo!
 * 
 * @author gazbert
 *
 */
public interface Product {

    public void setIsTaxable(boolean isTaxable);
    
    public boolean isTaxable();
    
    public String getProductDetails();
}
