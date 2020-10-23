package org.minecraftoss.catacomb.transaction;

public interface TransactionManager {

    TransactionResult handle(Transaction transaction, TransactionCondition condition);
}
