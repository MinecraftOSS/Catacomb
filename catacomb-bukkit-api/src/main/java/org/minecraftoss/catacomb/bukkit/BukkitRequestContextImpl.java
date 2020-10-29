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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BukkitRequestContextImpl)) return false;
        if (!super.equals(o)) return false;

        BukkitRequestContextImpl that = (BukkitRequestContextImpl) o;

        return requestIdentifier.equals(that.requestIdentifier);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + requestIdentifier.hashCode();
        return result;
    }
}
