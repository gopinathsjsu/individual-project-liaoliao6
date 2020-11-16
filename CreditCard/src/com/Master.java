package com;

public class Master extends CreditCard {

    public Master(String cardNumber) {
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
            if ((cardValue.length() == 16) && (cardValue.charAt(0) == '5') && (cardValue.charAt(1) == '1' || cardValue.charAt(1) == '2' || cardValue.charAt(1) == '3' || cardValue.charAt(1) == '4' )) {
                return "MasterCard";
            }
        }catch(Exception e){
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
