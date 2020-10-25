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
}
