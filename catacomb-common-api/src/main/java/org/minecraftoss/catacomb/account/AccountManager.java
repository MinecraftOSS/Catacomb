package org.minecraftoss.catacomb.account;

import org.minecraftoss.catacomb.account.request.RequestContext;

public interface AccountManager {

    Account getAccount(RequestContext context);
}
