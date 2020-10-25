package org.minecraftoss.catacomb.transaction;

public interface TransactionContext {

    static TransactionContext of(String key, String value) {
        return new TransactionContextImpl(key, value);
    }

    String getKey();

    String getValue();
}
