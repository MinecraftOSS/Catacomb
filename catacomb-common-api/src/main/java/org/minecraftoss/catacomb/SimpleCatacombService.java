package org.minecraftoss.catacomb;

import org.minecraftoss.catacomb.account.AccountManager;

import java.util.EnumSet;
import java.util.Set;

public class SimpleCatacombService implements CatacombService {
    private final EconomyManager economyManager;
    private final AccountManager accountManager;
    private final Set<Capability> capabilities;

    public SimpleCatacombService(EconomyManager economyManager,
                                 AccountManager accountManager, Set<Capability> capabilities) {
        this.economyManager = economyManager;
        this.accountManager = accountManager;
        this.capabilities = EnumSet.copyOf(capabilities);
    }

    @Override
    public boolean queryCapabilities(Capability capability) {
        return this.capabilities.contains(capability);
    }

    @Override
    public boolean queryCapabilities(Set<Capability> capabilities) {
        return this.capabilities.containsAll(capabilities);
    }

    @Override
    public EconomyManager getEconomyManager() {
        return this.economyManager;
    }

    @Override
    public AccountManager getAccountManager() {
        return this.accountManager;
    }
}
