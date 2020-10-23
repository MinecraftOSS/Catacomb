package org.minecraftoss.catacomb.transaction;

public interface TransactionResultState<T extends Enum<T> & TransactionResultState<T>> {

    enum BuiltinTransactionResultState implements TransactionResultState<BuiltinTransactionResultState> {
        ACCEPTED,
        DECLINED
    }
}
