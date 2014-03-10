package com.gazbert.patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * Platinum Account holder can have overdraft.
 * 
 * @author gazbert
 *
 */
public class PlatinumAccount extends AbstractAccount {

    public PlatinumAccount(final BigDecimal balance)
    {
        super(balance, true);
    }
}
