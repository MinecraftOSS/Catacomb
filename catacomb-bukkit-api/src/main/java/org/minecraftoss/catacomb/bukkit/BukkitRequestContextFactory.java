package org.minecraftoss.catacomb.bukkit;

import org.bukkit.plugin.Plugin;
import org.minecraftoss.catacomb.account.request.RequestContext;
import org.minecraftoss.catacomb.account.request.RequestContextFactory;

import java.util.UUID;

public class BukkitRequestContextFactory implements RequestContextFactory {

    private final Plugin plugin;

    private BukkitRequestContextFactory(Plugin plugin) {
        this.plugin = plugin;
    }

    static BukkitRequestContextFactory forPlugin(Plugin plugin) {
        return new BukkitRequestContextFactory(plugin);
    }

    @Override
    public RequestContext fromAccountIdentifier(UUID accountIdentifier) {
        return BukkitRequestContext.pluginRequest(accountIdentifier, this.plugin);
    }
}
