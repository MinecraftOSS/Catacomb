package org.minecraftoss.catacomb.account.request;

import org.minecraftoss.catacomb.account.Account;
import org.minecraftoss.catacomb.account.AccountContext;
import org.minecraftoss.catacomb.account.AccountManager;

import java.util.UUID;

/**
 * The context of an {@link Account} request.
 *
 * <p>When requesting an account, a {@link UUID} and a {@link RequestContext}
 * is required. Depending on the context, the {@link AccountContext} associated with
 * the returned account might vary.
 *
 * @see AccountManager#getAccount(RequestContext)
 * @see Account#getAccountContext()
 */
public interface RequestContext {

    static RequestContext rawRequest(UUID accountId,  String requestId) {
        return new RequestContextImpl(accountId, requestId);
    }

    /**
     * The identifier used to identify the request. For example, this
     * could be a plugin's name.
     *
     * @return the identifier of this context.
     */
    String getRequesterIdentifier(); // TODO maybe use something like a "hierarchical key" (similar to permissions) or namespaced

    UUID getAccountIdentifier();
}
