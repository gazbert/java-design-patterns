package com.gazbert.patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * Standard Account holder cannot have overdraft.
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