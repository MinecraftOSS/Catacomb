package org.minecraftoss.catacomb.sponge;

import org.minecraftoss.catacomb.account.request.RequestContext;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.UUID;

public interface SpongeRequestContext extends RequestContext {

    static SpongeRequestContext pluginRequest(UUID accountId, PluginContainer plugin) {
        return new SpongeRequestContextImpl(accountId, plugin);
    }

    PluginContainer getPlugin();

    @Override
    default String getRequesterIdentifier() {
        return getPlugin().getId();
    }
}
