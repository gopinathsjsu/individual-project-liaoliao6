package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class AmericanExpressTest {

    @Test
    public void testIdentifyAECardType() {
        AmericanExpress ax = new AmericanExpress("3.41E+14");
        String result = ax.identifyCardType("3.41E+14");
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
        AmericanExpress ax = new AmericanExpress("351000000000000");
        String result = ax.identifyCardType("351000000000000");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAESecondDigit(){
        AmericanExpress ax = new AmericanExpress("371000000000000");
        String result = ax.identifyCardType("371000000000000");
        assertEquals("AmericanExpress", result);
    }

    @Test
    public void testAEWithSpecialCharacters(){
        AmericanExpress ax = new AmericanExpress("37100000,000000");
        String result = ax.identifyCardType("37100000,000000");
        assertEquals("Invalid", result);
    }

    @Test
    public void testAEWithWhiteSpacesInBetween(){
        AmericanExpress ax = new AmericanExpress("37100000  000000");
        String result = ax.identifyCardType("37100000  000000");
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
        AmericanExpress ax = new AmericanExpress("471000000000000");
        String result = ax.identifyCardType("471000000000000");
        assertEquals("Invalid", result);
    }

}