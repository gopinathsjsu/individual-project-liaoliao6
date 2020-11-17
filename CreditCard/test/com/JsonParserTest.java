package com;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class JsonParserTest {

    private JsonParser jsonParserUnderTest;

    @Before
    public void setUp() {

        jsonParserUnderTest = new JsonParser();
    }

    @Test
    public void testProcessEachData() {
        // Setup
        final JSONObject currentInfo = new JSONObject(new HashMap<>());
        final JSONObject expectedResult = new JSONObject(new HashMap<>());

        currentInfo.put("CardNumber","5410000000000000");
        currentInfo.put("ExpirationDate","3/20/2030");
        currentInfo.put("NameOfCardholder","Alice");

        expectedResult.put("CardNumber",Long.parseLong("5410000000000000"));
        expectedResult.put("CardType","MasterCard");
        expectedResult.put("Error","None");

        // Run the test
        final JSONObject result = jsonParserUnderTest.processEachData(currentInfo);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
