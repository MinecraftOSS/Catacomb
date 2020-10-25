package org.minecraftoss.catacomb.sponge;

import org.spongepowered.api.plugin.PluginContainer;

import java.util.UUID;

class SpongeRequestContextImpl implements SpongeRequestContext {
    private final UUID accountIdentifier;
    private final PluginContainer plugin;

    SpongeRequestContextImpl(UUID accountIdentifier, PluginContainer plugin) {
        this.accountIdentifier = accountIdentifier;
        this.plugin = plugin;
    }

    @Override
    public PluginContainer getPlugin() {
        return this.plugin;
    }

    @Override
    public UUID getAccountIdentifier() {
        return this.accountIdentifier;
    }
}
