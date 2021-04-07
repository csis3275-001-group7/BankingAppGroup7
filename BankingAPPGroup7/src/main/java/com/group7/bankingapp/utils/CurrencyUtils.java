package com.group7.bankingapp.utils;

import static com.group7.bankingapp.domain.enums.Currency.DOLLAR;
import static com.group7.bankingapp.domain.enums.Currency.EURO;
import static com.group7.bankingapp.domain.enums.Currency.POUND;

import com.group7.bankingapp.domain.enums.Currency;

public class CurrencyUtils {

    public static Currency convertStringToCurrency (String currency) {
        switch (currency.toLowerCase()) {
            case "euro":
                return EURO;
            case "dollar":
                return DOLLAR;
            case "pound":
                return POUND;

                default:
                    return EURO;

        }
    }
}
