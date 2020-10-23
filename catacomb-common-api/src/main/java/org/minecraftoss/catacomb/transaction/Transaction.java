package org.minecraftoss.catacomb.transaction;

import org.minecraftoss.catacomb.Currency;
import org.minecraftoss.catacomb.account.Account;
import org.minecraftoss.catacomb.account.AccountContext;

import java.math.BigDecimal;
import java.util.Set;

public interface Transaction {

    Account getAccountFrom();

    Account getAccountTo();

    Currency getCurrency();

    BigDecimal getAmount();

    Set<AccountContext> getContexts();
}
