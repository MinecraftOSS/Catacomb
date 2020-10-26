package org.minecraftoss.catacomb.transaction;

import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.account.Account;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

class TransactionImpl implements Transaction {
    private final Account accountFrom;
    private final Account accountTo;
    private final Currency currency;
    private final BigDecimal amount;
    private final Set<TransactionContext> contexts;

    TransactionImpl(Account accountFrom, Account accountTo, Currency currency, BigDecimal amount, Set<TransactionContext> contexts) {
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
    public Set<TransactionContext> getContexts() {
        return this.contexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionImpl)) return false;

        TransactionImpl that = (TransactionImpl) o;

        if (!accountFrom.equals(that.accountFrom)) return false;
        if (!accountTo.equals(that.accountTo)) return false;
        if (!currency.equals(that.currency)) return false;
        if (!amount.equals(that.amount)) return false;
        return contexts.equals(that.contexts);
    }

    @Override
    public int hashCode() {
        int result = accountFrom.hashCode();
        result = 31 * result + accountTo.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + contexts.hashCode();
        return result;
    }
}
