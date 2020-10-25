package org.minecraftoss.catacomb.account;

import org.minecraftoss.catacomb.CatacombService;
import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.Transaction;
import org.minecraftoss.catacomb.transaction.TransactionContext;
import org.minecraftoss.catacomb.transaction.TransactionCondition;
import org.minecraftoss.catacomb.transaction.result.TransactionResult;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface Account {

    UUID getIdentifier();

    default BigDecimal getBalance(Currency currency, Set<TransactionContext> contexts) {
        return getCatacombService().getEconomyManager().getBalance(getIdentifier(), currency, contexts);
    }

    default BigDecimal getBalance(Currency currency) {
        return getBalance(currency, getAccountContext().getDefaultContexts());
    }

    default BigDecimal getBalance() {
        return getBalance(getAccountContext().getDefaultCurrency());
    }

    BigDecimal getInitialBalance(Currency currency);

    default BigDecimal getInitialBalance() {
        return getInitialBalance(getAccountContext().getDefaultCurrency());
    }

     // account reset

    TransactionResult resetBalance(Currency currency, Set<TransactionContext> contexts);

    default TransactionResult resetBalance(Currency currency) {
        return resetBalance(currency, getAccountContext().getDefaultContexts());
    }

    default TransactionResult resetBalance() {
        return resetBalance(getAccountContext().getDefaultCurrency());
    }

    // transfer

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        Transaction transaction = Transaction.of(this, to, currency, amount, contexts);
        TransactionCondition andDefault = condition.and(getAccountContext().getDefaultTransactionCondition());
        return getCatacombService().getEconomyManager().handle(transaction, andDefault);
    }

    default TransactionResult transfer(Account to, BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        return transfer(to, getAccountContext().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount, Set<TransactionContext> contexts) {
        return transfer(to, currency, amount, getAccountContext().getDefaultTransactionCondition(), contexts);
    }

    default TransactionResult transfer(Account to, BigDecimal amount, Set<TransactionContext> contexts) {
        return transfer(to, getAccountContext().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount, TransactionCondition condition) {
        return transfer(to, currency, amount, condition, getAccountContext().getDefaultContexts());
    }

    default TransactionResult transfer(Account to, BigDecimal amount, TransactionCondition condition) {
        return transfer(to, getAccountContext().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult transfer(Account to, Currency currency, BigDecimal amount) {
        return transfer(to, currency, amount, getAccountContext().getDefaultTransactionCondition());
    }

    default TransactionResult transfer(Account to, BigDecimal amount) {
        return transfer(to, getAccountContext().getDefaultCurrency(), amount);
    }

    // withdraw

    default TransactionResult withdraw(Currency currency, BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        return transfer(infiniteAccount(), currency, amount, condition, contexts);
    }

    default TransactionResult withdraw(BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        return withdraw(getAccountContext().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount, Set<TransactionContext> contexts) {
        return withdraw(currency, amount, getAccountContext().getDefaultTransactionCondition(), contexts);
    }

    default TransactionResult withdraw(BigDecimal amount, Set<TransactionContext> contexts) {
        return withdraw(getAccountContext().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount, TransactionCondition condition) {
        return withdraw(currency, amount, condition, getAccountContext().getDefaultContexts());
    }

    default TransactionResult withdraw(BigDecimal amount, TransactionCondition condition) {
        return withdraw(getAccountContext().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult withdraw(Currency currency, BigDecimal amount) {
        return withdraw(currency, amount, getAccountContext().getDefaultTransactionCondition());
    }

    default TransactionResult withdraw(BigDecimal amount) {
        return withdraw(getAccountContext().getDefaultCurrency(), amount);
    }

    // deposit

    default TransactionResult deposit(Currency currency, BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        return infiniteAccount().transfer(this, currency, amount, condition, contexts);
    }

    default TransactionResult deposit(BigDecimal amount, TransactionCondition condition, Set<TransactionContext> contexts) {
        return deposit(getAccountContext().getDefaultCurrency(), amount, condition, contexts);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount, Set<TransactionContext> contexts) {
        return deposit(currency, amount, getAccountContext().getDefaultTransactionCondition(), contexts);
    }

    default TransactionResult deposit(BigDecimal amount, Set<TransactionContext> contexts) {
        return deposit(getAccountContext().getDefaultCurrency(), amount, contexts);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount, TransactionCondition condition) {
        return deposit(currency, amount, condition, getAccountContext().getDefaultContexts());
    }

    default TransactionResult deposit(BigDecimal amount, TransactionCondition condition) {
        return deposit(getAccountContext().getDefaultCurrency(), amount, condition);
    }

    default TransactionResult deposit(Currency currency, BigDecimal amount) {
        return deposit(currency, amount, getAccountContext().getDefaultTransactionCondition());
    }

    default TransactionResult deposit(BigDecimal amount) {
        return deposit(getAccountContext().getDefaultCurrency(), amount);
    }

    CatacombService getCatacombService();

    /**
     * The context of this account. While an account is uniquely identified
     * by {@link #getIdentifier()}, this allows to provide different context
     * to different users (e.g. third-party plugins).
     *
     * <p>Implementations of Catacomb might allow settings so different plugins
     * use different {@link Currency}, different default {@link TransactionCondition}.
     * @return the context of this account.
     */
    AccountContext getAccountContext();

    static Account infiniteAccount() {
        return InfiniteAccount.INSTANCE;
    }
}
