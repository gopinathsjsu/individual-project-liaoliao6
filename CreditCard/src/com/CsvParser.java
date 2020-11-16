package com;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvParser implements FileParser {
    private List<String> info;
    private List<String> outputInfo;

    public CsvParser() {
        outputInfo = new ArrayList<>();
        info = new ArrayList<>();
    }
    @Override
    public void getData(String inputFile) throws IOException {
        info.addAll(Files.readAllLines(Paths.get(inputFile)));
    }

    public void processData(String outputFile) throws IOException {
        InfoIterator iterator = new InfoIteratorImpl(info);
        String output;
        String currentInfo;

        outputInfo.add("CardNumber, CardType, Error");

        for(;!iterator.isDone();){
            currentInfo = iterator.currentString();
            if(currentInfo == ""){
                outputInfo.add("Line is Blank");
                iterator.goNext();
                continue;
            }
            output = this.processEachData(currentInfo);
            outputInfo.add(output);
            iterator.goNext();
        }
        this.writeFile(outputFile);
    }


    @Override
    public void writeFile(String outputFile) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFile);
        InfoIterator iterator = new InfoIteratorImpl(outputInfo);

        while (!iterator.isDone()){
            fileWriter.write(iterator.currentString() + "\n");
            iterator.goNext();
        }

    }

    public String processEachData (String currentInfo) {
        String output;
        String cardNumber;
        String cardType;
        String errorMessage = "None";

        cardNumber = currentInfo.split(",")[0];

        CreditCardFactory creditCardFactory = new SimpleCreditCardFactory();
        CreditCard creditCard = CreditCardFactory.createCard(cardNumber);

        if(creditCard == null){
            errorMessage = "Invalid card Number";
            cardType = "Invalid card type";
            return (cardNumber + ":" + cardType + "," + errorMessage);
        }

        output = creditCard.identifyCardType(cardNumber);

        if(output == "Invalid"){
            errorMessage = "Invalid card number";
        }
        cardType = output;
        return (cardNumber + ":" + cardType + "," + errorMessage);
    }


}
