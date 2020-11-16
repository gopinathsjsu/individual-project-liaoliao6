package com;

public class Visa extends CreditCard {

    public Visa(String cardNumber) {
        super(cardNumber);
    }

    @Override
    String identifyCardType(String cardNumber) {
        if (cardNumber == "") {
            return "Invalid";
        }
        try {
            long cardNumberLong = Double.valueOf(cardNumber).longValue();
            String cardValue = Long.toString(cardNumberLong);
            if ((cardValue.length() == 13 || cardValue.length() == 16) && cardValue.charAt(0) == '4') {
                return "Visa";
            }
        } catch (Exception e) {
            return "Invalid";
        }
        return "Invalid";
    }

    static boolean isValidString(String cardNumber) {
        String regex = "^[a-zA-Z]+$";
        if (cardNumber.matches(regex)) {
            return true;
        }

        return false;
    }
}