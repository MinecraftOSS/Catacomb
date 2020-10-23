package org.minecraftoss.catacomb.transaction;

import java.util.function.Predicate;

/**
 * A TransactionCondition checks if a {@link Transaction} is valid or not.
 *
 * <p>As an example, if the balance of an account might not be below 0,
 * a TransactionCondition can be used to check if the {@link Transaction}
 * fulfills that requirement.
 */
@FunctionalInterface
public interface TransactionCondition extends Predicate<Transaction> {

    static TransactionCondition allOf(Iterable<? extends TransactionCondition> conditions) {
        return transaction -> {
            for (TransactionCondition condition : conditions) {
                if (!condition.isFulfilled(transaction)) {
                    return false;
                }
            }
            return true;
        };
    }

    static TransactionCondition anyOf(Iterable<? extends TransactionCondition> conditions) {
        return transaction -> {
            for (TransactionCondition condition : conditions) {
                if (condition.isFulfilled(transaction)) {
                    return true;
                }
            }
            return false;
        };
    }

    static TransactionCondition always() {
        return transaction -> true;
    }

    static TransactionCondition never() {
        return transaction -> false;
    }

    boolean isFulfilled(Transaction transaction);

    @Override
    default boolean test(Transaction transaction) {
        return isFulfilled(transaction);
    }

    default TransactionCondition negate() {
        return transaction -> !isFulfilled(transaction);
    }

    default TransactionCondition and(TransactionCondition other) {
        return transaction -> isFulfilled(transaction) && other.isFulfilled(transaction);
    }

    default TransactionCondition or(TransactionCondition other) {
        return transaction -> isFulfilled(transaction) || other.isFulfilled(transaction);
    }

    default TransactionCondition xor(TransactionCondition other) {
        return transaction -> isFulfilled(transaction) ^ other.isFulfilled(transaction);
    }
}
