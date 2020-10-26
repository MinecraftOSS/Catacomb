package org.minecraftoss.catacomb.transaction.result;

public interface TransactionResultState<T extends Enum<T> & TransactionResultState<T>> {

    BuiltinTransactionResultState getParent();
}
