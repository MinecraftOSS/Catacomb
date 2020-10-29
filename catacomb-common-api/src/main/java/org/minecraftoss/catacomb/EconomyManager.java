package org.minecraftoss.catacomb;

import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.Transaction;
import org.minecraftoss.catacomb.transaction.TransactionCondition;
import org.minecraftoss.catacomb.transaction.TransactionContext;
import org.minecraftoss.catacomb.transaction.result.TransactionResult;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface EconomyManager {

    TransactionResult handle(Transaction transaction, TransactionCondition condition);

    BigDecimal getBalance(UUID identifier, Currency currency, Set<TransactionContext> contexts);
}
