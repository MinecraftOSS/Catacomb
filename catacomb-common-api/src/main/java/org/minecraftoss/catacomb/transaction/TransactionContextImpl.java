package org.minecraftoss.catacomb.transaction;

class TransactionContextImpl implements TransactionContext {
    private final String key;
    private final String value;

    TransactionContextImpl(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
