package org.minecraftoss.catacomb.transaction;

import org.minecraftoss.catacomb.currency.Currency;
import org.minecraftoss.catacomb.transaction.result.TransactionResult;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface EconomyManager {

    TransactionResult handle(Transaction transaction, TransactionCondition condition);

    BigDecimal getBalance(UUID identifier, Currency currency, Set<TransactionContext> contexts);
}
