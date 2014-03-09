package com.gazbert.patterns.creational.builder.account;

import java.math.BigDecimal;

/**
 * Standard Account holder.
 * 
 * @author gazbert
 *
 */
public class StandardAccount extends AbstractAccount {

    public StandardAccount(final BigDecimal balance)
    {
        super(balance, false);
    }
}