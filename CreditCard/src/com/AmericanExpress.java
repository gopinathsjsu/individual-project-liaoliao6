package com;

public class AmericanExpress extends CreditCard {

    public AmericanExpress(String cardNumber) {
        super(cardNumber);
    }

    @Override
    String identifyCardType(String cardNumber) {
        if(cardNumber == ""){
            return "Invalid";
        }
        try {
            long cardNumberLong = Double.valueOf(cardNumber).longValue();
            String cardValue = Long.toString(cardNumberLong);
            if ((cardValue.charAt(0) == '3')&&(cardValue.length() == 15) && (cardValue.charAt(1) == '4' || cardValue.charAt(1) == '7')) {
                return "AmericanExpress";
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
