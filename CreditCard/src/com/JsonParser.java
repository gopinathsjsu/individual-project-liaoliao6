package com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.transform.TransformerException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonParser implements FileParser {
    private JSONArray outputInfo;
    private JSONArray info;

    public JsonParser() {
        outputInfo = new JSONArray();
        info = new JSONArray();
    }

    @Override
    public void getData(String inputFile) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        Object obj = new JSONParser().parse(new FileReader(inputFile));
        info = (JSONArray) obj;
    }

    @Override
    public void processData(String outputFile) throws IOException, TransformerException {
        InfoIterator iterator = new InfoIteratorImpl(info, info.size());
        JSONObject output;

        for (; !iterator.isDone(); ) {
            JSONObject currentInfo = iterator.currentObject();
            output = this.processEachData(currentInfo);
            outputInfo.add(output);
            iterator.goNext();
        }
        this.writeFile(outputFile);
    }

    public JSONObject processEachData(JSONObject currentInfo) {
        String output;
        String cardNumber;
        String cardType = "Invalid";
        String errorMessage = "None";

        JSONObject row = new JSONObject();
        cardNumber = currentInfo.get("CardNumber").toString();

        CreditCardFactory creditCardFactory = new SimpleCreditCardFactory();
        CreditCard creditCard = CreditCardFactory.createCard(cardNumber);

        if (creditCard == null) {
            errorMessage = "Invalid card Number";
            cardType = "Invalid card type";
            row.put("CardNumber", Long.parseLong(cardNumber));
            row.put("CardType", cardType);
            row.put("Error", errorMessage);
            return row;
        }

        output = creditCard.identifyCardType(cardNumber);
        if (output == "Invalid") {
            errorMessage = "Invalid card Number";
            row.put("CardNumber", Long.parseLong(cardNumber));
            row.put("CardType", cardType);
            row.put("Error", errorMessage);
            return row;
        }
        return row;
    }

    @Override
    public void writeFile(String outputFile) throws IOException {
        FileWriter file = new FileWriter(outputFile);
        file.write(outputInfo.toJSONString());
    }

}
