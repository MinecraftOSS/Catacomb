package org.minecraftoss.catacomb.sponge;

import org.minecraftoss.catacomb.account.request.RequestContext;
import org.minecraftoss.catacomb.account.request.RequestContextFactory;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.UUID;

public class SpongeRequestContextFactory implements RequestContextFactory {
    private final PluginContainer plugin;

    SpongeRequestContextFactory(PluginContainer plugin) {
        this.plugin = plugin;
    }

    static SpongeRequestContextFactory forPlugin(PluginContainer plugin) {
        return new SpongeRequestContextFactory(plugin);
    }

    @Override
    public RequestContext fromAccountIdentifier(UUID accountIdentifier) {
        return SpongeRequestContext.pluginRequest(accountIdentifier, plugin);
    }
}
