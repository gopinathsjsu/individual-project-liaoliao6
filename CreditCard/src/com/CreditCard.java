package com;

abstract class CreditCard {

    private String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    abstract String identifyCardType(String cardNumber);

}
