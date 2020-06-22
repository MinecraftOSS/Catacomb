package org.minecraftoss.catacomb.sponge;

import org.spongepowered.api.plugin.PluginContainer;

import java.util.UUID;

// For lack of a better name
public class UUIDUtil {

    public static UUID getPluginUUID(PluginContainer plugin, double id) {
        return org.minecraftoss.catacomb.UUIDUtil.createStringUUID(plugin.getId(), id);
    }

}
