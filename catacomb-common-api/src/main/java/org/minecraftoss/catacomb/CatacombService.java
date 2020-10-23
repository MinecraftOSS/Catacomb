package org.minecraftoss.catacomb;

import org.minecraftoss.catacomb.account.AccountManager;
import org.minecraftoss.catacomb.currency.CurrencyManager;
import org.minecraftoss.catacomb.transaction.TransactionManager;

import java.util.Set;

public interface CatacombService {

    default boolean queryCapabilities(Capability capability) {
        return false;
    }

    default boolean queryCapabilities(Set<Capability> capabilities) {
        for (Capability capability : capabilities) {
            if (!queryCapabilities(capability)) {
                return false;
            }
        }
        return true;
    }

    CurrencyManager getCurrencyManager();

    TransactionManager getTransactionManager();

    AccountManager getAccountManager();
}
