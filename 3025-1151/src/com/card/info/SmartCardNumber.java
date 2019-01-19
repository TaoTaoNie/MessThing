package com.card.info;

import java.util.HashMap;
import java.util.Map;

public class SmartCardNumber {
    private String firstName;
    private String lastName;
    private String year;
    private String number;

    private static final Map<String, SmartCardNumber> NUMBERS = new HashMap<String, SmartCardNumber>();

    private SmartCardNumber(String firstName, String lastName, String year, String number) {
        if (firstName == null || lastName == null || year == null || number == null)
            throw new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.number = number;
    }

    public static SmartCardNumber getInstance(String firstName, String lastName, String year, String number) {
        final String firstAlphabet = firstName.substring(0, 1).toUpperCase();
        final String lastAlphabet = lastName.substring(0, 1).toUpperCase();
        final String k = firstAlphabet + lastAlphabet + "-" + year + "-" + number;
        if (!NUMBERS.containsKey(k)) {
            NUMBERS.put(k, new SmartCardNumber(firstAlphabet, lastAlphabet, year, number));
            return NUMBERS.get(k);
        }
        throw new IllegalArgumentException("Cannot have the same smart card number!");
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName + "-" + this.year + "-" + this.number;
    }

    public static SmartCardNumber valueOf(String smartCardNumber) {
        if (NUMBERS.containsKey(smartCardNumber))
            throw new IllegalArgumentException("Cannot have the same smart card number!");
        final String[] parts = smartCardNumber.split("-");
        final String fistAlphabet = parts[0].substring(0, 1);
        final String lastAlphabet = parts[0].substring(1, 2);
        final String year = parts[1];
        final String number = parts[2];
        NUMBERS.put(smartCardNumber, new SmartCardNumber(fistAlphabet, lastAlphabet, year, number));
        return NUMBERS.get(smartCardNumber);
    }

}
