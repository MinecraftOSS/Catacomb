package org.minecraftoss.catacomb;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "catacomb",
        name = "Catacomb",
        description = "Provides Sponge compatibility for cross-platform Catacomb plugins",
        url = "https://github.com/MinecraftOSS/Catacomb",
        authors = {
                "mbaxter",
                "md678685"
        }
)
public class CatacombSponge {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
