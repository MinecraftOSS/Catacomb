package org.minecraftoss.catacomb.sponge;

import org.minecraftoss.catacomb.account.request.RequestContextImpl;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.UUID;

class SpongeRequestContextImpl extends RequestContextImpl implements SpongeRequestContext {
    private final PluginContainer plugin;

    SpongeRequestContextImpl(UUID accountIdentifier, PluginContainer requestIdentifier) {
        super(accountIdentifier, requestIdentifier.getId());
        this.plugin = requestIdentifier;
    }

    @Override
    public PluginContainer getPlugin() {
        return this.plugin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpongeRequestContextImpl)) return false;
        if (!super.equals(o)) return false;

        SpongeRequestContextImpl that = (SpongeRequestContextImpl) o;

        return plugin.equals(that.plugin);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + plugin.hashCode();
        return result;
    }
}
