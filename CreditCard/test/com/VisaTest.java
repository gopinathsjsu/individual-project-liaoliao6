package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class VisaTest {

    @Test
    public void testNoVisaCardNumber(){
        Visa v = new Visa("");
        String result = v.identifyCardType("");
        assertEquals("Invalid", result);
    }

    @Test
    public void testValidateVisaCardType() {
        Visa v = new Visa("4.67E+15");
        String result = v.identifyCardType("4.67E+15");
        assertEquals("Visa", result);
    }

    @Test
    public void testVisaCardWhiteSpaces() {
        Visa v = new Visa("  ");
        String result = v.identifyCardType("  ");
        assertEquals("Invalid", result);
    }

    @Test
    public void testVisaCardWith14Digits() {
        Visa v = new Visa("45678907654321");
        String result = v.identifyCardType("45678907654321");
        assertEquals("Invalid", result);
    }

    @Test
    public void testVisaCardWithCharacters() {
        Visa v = new Visa("45678ycv34567");
        String result = v.identifyCardType("45678ycv34567");
        assertEquals("Invalid", result);
    }

    @Test
    public void testWrongVisaNumber() {
        Visa v = new Visa("8567891324567765");
        String result = v.identifyCardType("8567891324567765");
        assertEquals("Invalid", result);
    }

    @Test
    public void testValid16DigitVisaCard() {
        Visa v = new Visa("4123451234567765");
        String result = v.identifyCardType("4123451234567765");
        assertEquals("Visa", result);
    }

    @Test
    public void test_Invalid_SpecialCharacter_In_VisaCard() {
        Visa v = new Visa("48888888$8888888");
        String result = v.identifyCardType("48888888$8888888");
        assertEquals("Invalid", result);
    }
}