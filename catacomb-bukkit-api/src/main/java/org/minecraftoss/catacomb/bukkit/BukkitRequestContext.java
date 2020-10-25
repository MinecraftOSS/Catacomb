package org.minecraftoss.catacomb.bukkit;

import org.bukkit.plugin.Plugin;
import org.minecraftoss.catacomb.account.request.RequestContext;

import java.util.UUID;

public interface BukkitRequestContext extends RequestContext {

    static BukkitRequestContext pluginRequest(UUID accountId, Plugin requestId) {
        return new BukkitRequestContextImpl(accountId, requestId);
    }

    Plugin getRequestIdentifier();

    @Override
    default String getRequesterIdentifier() {
        return getRequestIdentifier().getName();
    }
}
