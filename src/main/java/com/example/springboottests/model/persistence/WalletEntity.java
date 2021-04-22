package com.example.springboottests.model.persistence;

import java.util.Currency;
import java.util.Locale;

public class WalletEntity {
    Currency currency = Currency.getInstance(Locale.US);

    public Currency getCurrency() {
        return Currency.getInstance(Locale.US);
    }
}
