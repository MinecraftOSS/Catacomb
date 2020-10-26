package org.minecraftoss.catacomb.transaction.result;

import org.minecraftoss.catacomb.transaction.Transaction;

public class TransactionResult {
    private final TransactionResultState<?> transactionResultState;
    private final Transaction transaction;

    private TransactionResult(TransactionResultState<?> transactionResultState, Transaction transaction) {
        this.transactionResultState = transactionResultState;
        this.transaction = transaction;
    }

    public static TransactionResult of(TransactionResultState<?> transactionResultState, Transaction transaction) {
        return new TransactionResult(transactionResultState, transaction);
    }

    public TransactionResultState<?> getTransactionResultState() {
        return this.transactionResultState;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    // TODO track changes?


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionResult)) return false;

        TransactionResult that = (TransactionResult) o;

        if (!transactionResultState.equals(that.transactionResultState)) return false;
        return transaction.equals(that.transaction);
    }

    @Override
    public int hashCode() {
        int result = transactionResultState.hashCode();
        result = 31 * result + transaction.hashCode();
        return result;
    }
}
