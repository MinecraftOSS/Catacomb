package org.minecraftoss.catacomb.bukkit;

import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class UUIDUtil {

    public static UUID createPluginUUID(Plugin plugin, double id) {
        return org.minecraftoss.catacomb.UUIDUtil.createStringUUID(plugin.getName(), id);
    }

}
