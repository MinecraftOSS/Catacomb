package org.minecraftoss.catacomb.account;

import org.minecraftoss.catacomb.CatacombService;
import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.Transaction;
import org.minecraftoss.catacomb.transaction.TransactionCondition;
import org.minecraftoss.catacomb.transaction.TransactionContext;
import org.minecraftoss.catacomb.transaction.result.TransactionResult;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

enum InfiniteAccount implements Account {
    INSTANCE;

    // TODO
    private final UUID id = UUID.nameUUIDFromBytes(new byte[0]);

    @Override
    public UUID getIdentifier() {
        return this.id;
    }

    @Override
    public BigDecimal getBalance(Currency currency) {
        return getInitialBalance(currency);
    }

    @Override
    public BigDecimal getInitialBalance(Currency currency) {
        return BigDecimal.valueOf(Double.MAX_VALUE);
    }

    @Override
    public TransactionResult resetBalance(Currency currency, Set<TransactionContext> contexts) {
        throw new UnsupportedOperationException("Cannot reset infinite account");
    }

    @Override
    public TransactionResult transfer(Account to, Currency currency, BigDecimal amount,
                                      TransactionCondition condition, Set<TransactionContext> contexts) {
        Transaction transaction = Transaction.of(this, to, currency, amount, contexts);
        return to.getCatacombService().getEconomyManager().handle(transaction, condition);
    }

    @Override
    public CatacombService getCatacombService() {
        throw new UnsupportedOperationException("No associated catacomb service for infinite account");
    }

    @Override
    public AccountContext getAccountContext() {
        throw new UnsupportedOperationException("No associated account context");
    }
}
