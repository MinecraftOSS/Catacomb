package org.minecraftoss.catacomb.account;

import org.minecraftoss.catacomb.CatacombService;
import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.Transaction;
import org.minecraftoss.catacomb.transaction.TransactionCondition;
import org.minecraftoss.catacomb.transaction.TransactionResult;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

public interface Account {

    // TODO identification stuff

    BigDecimal getBalance(Currency currency);

    BigDecimal getInitialBalance(Currency currency);

    Set<AccountContext> getActiveContexts();

    TransactionResult resetBalance(Currency currency, Set<AccountContext> contexts);

    default TransactionResult resetBalance(Currency currency) {
        return resetBalance(currency, getActiveContexts());
    }

    // transfer

    TransactionResult transfer(Account to, Currency currency, BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts);

    default TransactionResult transfer(Account to, BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts) {
        return transfer(to, getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount, Set<AccountContext> contexts) {
        return transfer(to, currency, amount, TransactionCondition.always(), contexts);
    }

    default TransactionResult transfer(Account to, BigDecimal amount, Set<AccountContext> contexts) {
        return transfer(to, getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount, TransactionCondition condition) {
        return transfer(to, currency, amount, condition, getActiveContexts());
    }

    default TransactionResult transfer(Account to, BigDecimal amount, TransactionCondition condition) {
        return transfer(to, getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount) {
        return transfer(to, currency, amount, TransactionCondition.always());
    }

    default TransactionResult transfer(Account to, BigDecimal amount) {
        return transfer(to, getCatacombService().getCurrencyManager().getDefaultCurrency(), amount);
    }

    // withdraw

    default TransactionResult withdraw(Currency currency, BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts) {
        return transfer(infiniteAccount(), currency, amount, condition, contexts);
    }

    default TransactionResult withdraw(BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts) {
        return withdraw(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount, Set<AccountContext> contexts) {
        return withdraw(currency, amount, TransactionCondition.always(), contexts);
    }

    default TransactionResult withdraw(BigDecimal amount, Set<AccountContext> contexts) {
        return withdraw(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount, TransactionCondition condition) {
        return withdraw(currency, amount, condition, getActiveContexts());
    }

    default TransactionResult withdraw(BigDecimal amount, TransactionCondition condition) {
        return withdraw(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount) {
        return withdraw(currency, amount, TransactionCondition.always());
    }

    default TransactionResult withdraw(BigDecimal amount) {
        return withdraw(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount);
    }

    // deposit

    default TransactionResult deposit(Currency currency, BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts) {
        return infiniteAccount().transfer(this, currency, amount, condition, contexts);
    }

    default TransactionResult deposit(BigDecimal amount, TransactionCondition condition, Set<AccountContext> contexts) {
        return deposit(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount, Set<AccountContext> contexts) {
        return deposit(currency, amount, TransactionCondition.always(), contexts);
    }

    default TransactionResult deposit(BigDecimal amount, Set<AccountContext> contexts) {
        return deposit(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount, TransactionCondition condition) {
        return deposit(currency, amount, condition, getActiveContexts());
    }

    default TransactionResult deposit(BigDecimal amount, TransactionCondition condition) {
        return deposit(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount) {
        return deposit(currency, amount, TransactionCondition.always());
    }

    default TransactionResult deposit(BigDecimal amount) {
        return deposit(getCatacombService().getCurrencyManager().getDefaultCurrency(), amount);
    }

    CatacombService getCatacombService();

    static Account infiniteAccount() {
        return new Account() {
            @Override
            public BigDecimal getBalance(Currency currency) {
                return getInitialBalance(currency);
            }

            @Override
            public BigDecimal getInitialBalance(Currency currency) {
                return BigDecimal.valueOf(Double.MAX_VALUE);
            }

            @Override
            public Set<AccountContext> getActiveContexts() {
                return Collections.emptySet();
            }

            @Override
            public TransactionResult resetBalance(Currency currency, Set<AccountContext> contexts) {
                throw new UnsupportedOperationException("Cannot reset infinite account");
            }

            @Override
            public TransactionResult transfer(Account to, Currency currency, BigDecimal amount,
                                                   TransactionCondition condition, Set<AccountContext> contexts) {
                Transaction transaction = Transaction.of(this, to, currency, amount, contexts);
                return to.getCatacombService().getTransactionManager().handle(transaction, condition);
            }

            @Override
            public CatacombService getCatacombService() {
                throw new UnsupportedOperationException("No associated catacomb service for infinite account");
            }
        };
    }
}
