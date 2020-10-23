package org.minecraftoss.catacomb.transaction;

public interface TransactionResultState<T extends Enum<?> & TransactionResultState<T>> {

    enum BuiltinTransactionResultState implements TransactionResultState<BuiltinTransactionResultState> {
        ACCEPTED,
        DECLINED
    }
}
