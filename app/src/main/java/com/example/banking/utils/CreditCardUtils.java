package com.example.banking.utils;

public class CreditCardUtils {
    public static final int VISA_PREFIX = 4;
    public static final int MASTER_PREFIX_1 = 5;
    public static final int MASTER_PREFIX_2_MIN = 51;
    public static final int MASTER_PREFIX_2_MAX = 55;

    public static String getCardType(String cardNumber) {
        String cleanedNumber = cardNumber.replaceAll("\\s+", ""); // Remove any spaces
        if (cleanedNumber.length() < 1) {
            return "Unknown";
        }

        int firstDigit = Character.getNumericValue(cleanedNumber.charAt(0));

        if (firstDigit == VISA_PREFIX) {
            return "Visa";
        } else if (firstDigit == MASTER_PREFIX_1 && cleanedNumber.length() >= 2) {
            int prefix2 = Integer.parseInt(cleanedNumber.substring(0, 2));
            if (prefix2 >= MASTER_PREFIX_2_MIN && prefix2 <= MASTER_PREFIX_2_MAX) {
                return "Mastercard";
            }
        }

        return "Unknown";
    }
}
