package org.minecraftoss.catacomb.account.request;

import java.util.UUID;

public class RequestContextImpl implements RequestContext {

    private final UUID accountIdentifier;
    private final String requestIdentifier;

    protected RequestContextImpl(UUID accountIdentifier, String requestIdentifier) {
        this.accountIdentifier = accountIdentifier;
        this.requestIdentifier = requestIdentifier;
    }

    @Override
    public UUID getAccountIdentifier() {
        return this.accountIdentifier;
    }

    @Override
    public String getRequesterIdentifier() {
        return this.requestIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestContextImpl)) return false;

        RequestContextImpl that = (RequestContextImpl) o;

        if (!accountIdentifier.equals(that.accountIdentifier)) return false;
        return requestIdentifier.equals(that.requestIdentifier);
    }

    @Override
    public int hashCode() {
        int result = accountIdentifier.hashCode();
        result = 31 * result + requestIdentifier.hashCode();
        return result;
    }
}
