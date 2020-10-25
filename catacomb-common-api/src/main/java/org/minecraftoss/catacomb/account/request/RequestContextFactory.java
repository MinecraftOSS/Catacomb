package org.minecraftoss.catacomb.account.request;

import java.util.UUID;

public interface RequestContextFactory {

    RequestContext fromAccountIdentifier(UUID accountIdentifier);
}
