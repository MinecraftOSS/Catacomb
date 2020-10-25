package org.minecraftoss.catacomb.account;

import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.TransactionCondition;
import org.minecraftoss.catacomb.transaction.TransactionContext;

import java.util.Set;

public interface AccountContext {

    TransactionCondition getDefaultTransactionCondition();

    Currency getDefaultCurrency();

    Set<TransactionContext> getDefaultContexts();

    // TODO better name?
    /**
     * The account that is used for withdraw/deposit transactions as target/source.
     *
     * @return an infinite account.
     */
    Account getInfiniteAccount();
}
