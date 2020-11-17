package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class AmericanExpressTest {

    @Test
    public void testIdentifyAECardType() {
        AmericanExpress ax = new AmericanExpress("3.72E+14");
        String result = ax.identifyCardType("3.72E+14");
        assertEquals("AmericanExpress", result);
    }

    @Test
    public void testNoAENumber(){
        AmericanExpress ax = new AmericanExpress("");
        String result = ax.identifyCardType("");
        assertEquals("Invalid", result);
    }

    @Test
    public void testSecondDigitAENumber(){
        AmericanExpress ax = new AmericanExpress("387123456712345");
        String result = ax.identifyCardType("387123456712345");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAESecondDigit(){
        AmericanExpress ax = new AmericanExpress("343123456789012");
        String result = ax.identifyCardType("343123456789012");
        assertEquals("AmericanExpress", result);
    }

    @Test
    public void testAEWithSpecialCharacters(){
        AmericanExpress ax = new AmericanExpress("37123456,123456");
        String result = ax.identifyCardType("37123456,123456");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAEWithWhiteSpacesInBetween(){
        AmericanExpress ax = new AmericanExpress("37123456  123456");
        String result = ax.identifyCardType("37123456  123456");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAEWithOnlyWhiteSpaces(){
        AmericanExpress ax = new AmericanExpress("   ");
        String result = ax.identifyCardType("   ");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAEWithFirstDigit(){
        AmericanExpress ax = new AmericanExpress("47112345678912");
        String result = ax.identifyCardType("47112345678912");
        assertEquals("Invalid", result);
    }

}