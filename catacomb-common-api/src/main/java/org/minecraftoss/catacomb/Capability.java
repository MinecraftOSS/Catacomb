package org.minecraftoss.catacomb;

@SuppressWarnings("unused")
public enum Capability {

    /**
     * Accounts that are provided by a third-party plugin.
     *
     * <p>If this capability isn't provided, third-party plugins
     * can't use the implementation to have e.g. shared accounts.
     */
    PLUGIN_ACCOUNTS,

    /**
     * Different contexts for accounts.
     *
     * <p>If this capability isn't provided, third-party plugins
     * can't use the implementation to have e.g. a bank account
     * and a wallet for one player. Alternatively, {@link #PLUGIN_ACCOUNTS}
     * could be used to achieve the same functionality in some cases.
     */
    CONTEXTS,

    /**
     * More than one currency.
     *
     * <p>If this capability isn't provided, third-party plugins
     * can't use the implementation to have different currencies.
     * Depending on the use case, {@link #PLUGIN_ACCOUNTS} could be
     * used if provided.
     */
    MULTIPLE_CURRENCIES
}
