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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionContextImpl)) return false;

        TransactionContextImpl that = (TransactionContextImpl) o;

        if (!key.equals(that.key)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
