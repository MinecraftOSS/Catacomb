package org.minecraftoss.catacomb.bukkit;

import org.bukkit.plugin.Plugin;
import org.minecraftoss.catacomb.account.request.RequestContextImpl;

import java.util.UUID;

class BukkitRequestContextImpl extends RequestContextImpl implements BukkitRequestContext {

    private final Plugin requestIdentifier;

    BukkitRequestContextImpl(UUID accountIdentifier, Plugin requestIdentifier) {
        super(accountIdentifier, requestIdentifier.getName());
        this.requestIdentifier = requestIdentifier;
    }

    @Override
    public Plugin getRequestIdentifier() {
        return this.requestIdentifier;
    }
}
