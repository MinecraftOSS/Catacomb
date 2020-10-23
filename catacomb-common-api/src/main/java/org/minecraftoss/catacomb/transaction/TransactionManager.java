package org.minecraftoss.catacomb.transaction;

import org.minecraftoss.catacomb.Currency;
import org.minecraftoss.catacomb.account.Account;
import org.minecraftoss.catacomb.account.AccountContext;

import java.math.BigDecimal;
import java.util.Set;

public interface TransactionManager {

    TransactionResult handle(Transaction transaction, TransactionCondition condition);

    Transaction createTransaction(Account from, Account to, Currency currency, BigDecimal amount, Set<AccountContext> contexts);
}
