package com;

public class SimpleCreditCardFactory implements CreditCardFactory {
    static CreditCard createCard(final String cardNumber){

        if (cardNumber == ""){
            return null;
        }
        try {
            long cardNumberLong = Double.valueOf(cardNumber).longValue();
            String cardValue = Long.toString(cardNumberLong);
            if (AmericanExpress.isValidString(cardValue)) {
                return new AmericanExpress(cardNumber);
            }

            if (Visa.isValidString(cardValue)) {
                return new Visa(cardNumber);
            }

            if (Master.isValidString(cardValue)) {
                return new Master(cardNumber);
            }

            if (Discover.isValidString(cardValue)) {
                return new Discover(cardNumber);
            }
            return null;

        }catch (Exception e) {
            return null;
        }

    }
}
