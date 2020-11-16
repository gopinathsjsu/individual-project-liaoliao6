package com;

public class Discover extends CreditCard {

    public Discover(String cardNumber) {
        super(cardNumber);
    }

    @Override
    String identifyCardType(String cardNumber) {
        if (cardNumber == ""){
            return "Invalid";
        }
        try {
            long cardNumberLong = Double.valueOf(cardNumber).longValue();
            String cardValue = Long.toString(cardNumberLong);
            if ((cardValue.charAt(0) == '6') && (cardValue.charAt(1) == '0') && (cardValue.charAt(2) == '1') && (cardValue.charAt(3) == '1')  && (cardValue.length() == 16))  {
                return "Discover";
            }
        }catch(Exception e) {
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
