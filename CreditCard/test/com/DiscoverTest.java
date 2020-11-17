package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscoverTest {

    @Test
    public void testNoDiscoverNumber(){
        Discover d = new Discover("");
        String result = d.identifyCardType("");
        assertEquals("Invalid", result);
    }

    @Test
    public void testIdentifyDiscoverCardType() {
        Discover d = new Discover("6.011E+15");
        String result = d.identifyCardType("6.011E+15");
        assertEquals("Discover", result);
    }

    @Test
    public void testFalseDiscoverCardType() {
        Discover d = new Discover("6.018E+15");
        String result = d.identifyCardType("6.018E+15");
        assertEquals("Invalid", result);
    }

    @Test
    public void testInvalidDiscoverCardType(){
        Discover d = new Discover("6345686789012345");
        String result = d.identifyCardType("6345686789012345");
        assertEquals("Invalid", result);
    }


    @Test
    public void testCharacterInFirstFourIndex(){
        Discover d = new Discover("6abcdef890123456");
        String result = d.identifyCardType("6abcdef890123456");
        assertEquals("Invalid", result);
    }

    @Test
    public void testCharacterInAnyIndex(){
        Discover d = new Discover("601166789_015_456");
        String result = d.identifyCardType("601166789_015_456");
        assertEquals("Invalid", result);
    }

    @Test
    public void Should_ReturnInvalid_With_WhiteSpaces(){
        Discover d = new Discover("   ");
        String result = d.identifyCardType("  ");
        assertEquals("Invalid", result);
    }

    @Test
    public void testValidDiscoverCardType(){
        Discover d = new Discover("6011582784756127");
        String result = d.identifyCardType("6011582784756127");
        assertEquals("Discover", result);
    }
}