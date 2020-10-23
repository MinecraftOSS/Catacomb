package org.minecraftoss.catacomb.transaction;

import org.minecraftoss.catacomb.Currency;
import org.minecraftoss.catacomb.account.Account;
import org.minecraftoss.catacomb.account.AccountContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

public class TransactionImpl implements Transaction {
    private final Account accountFrom;
    private final Account accountTo;
    private final Currency currency;
    private final BigDecimal amount;
    private final Set<AccountContext> contexts;

    public TransactionImpl(Account accountFrom, Account accountTo, Currency currency, BigDecimal amount, Set<AccountContext> contexts) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.currency = currency;
        this.amount = amount;
        this.contexts = Collections.unmodifiableSet(contexts);
    }

    @Override
    public Account getAccountFrom() {
        return this.accountFrom;
    }

    @Override
    public Account getAccountTo() {
        return this.accountTo;
    }

    @Override
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }

    @Override
    public Set<AccountContext> getContexts() {
        return this.contexts;
    }
}
