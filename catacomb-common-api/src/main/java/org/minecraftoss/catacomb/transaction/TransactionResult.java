package org.minecraftoss.catacomb.transaction;

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
}
