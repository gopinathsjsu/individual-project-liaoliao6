package com;

import org.junit.Test;

import static org.junit.Assert.*;

public class MasterTest {

    @Test
    public void testIdentifyMasterCardType() {
        Master mc = new Master("5.41E+15");
        String result = mc.identifyCardType("5.41E+15");
        assertEquals("MasterCard", result);
    }

    @Test
    public void testSecondDigitNotInclusiveOneAndFive(){
        Master mc = new Master("5.61E+15");
        String result = mc.identifyCardType("5.61E+15");
        assertEquals("Invalid", result);
    }

    @Test
    public void testNoMasterCardNumber(){
        Master mc = new Master("");
        String result = mc.identifyCardType("");
        assertEquals("Invalid", result);
    }

    @Test
    public void testMasterCardNumberWithWhiteSpaces(){
        Master mc = new Master("  ");
        String result = mc.identifyCardType("  ");
        assertEquals("Invalid", result);
    }

    @Test
    public void testMasterCardNumberWithSpecialCharacters(){
        Master mc = new Master("541000000+000000");
        String result = mc.identifyCardType("541000000+000000");
        assertEquals("Invalid", result);
    }

    @Test
    public void testMasterCardNumberWithCharacter(){
        Master mc = new Master("541000000v000000");
        String result = mc.identifyCardType("541000000v000000");
        assertEquals("Invalid", result);
    }
}