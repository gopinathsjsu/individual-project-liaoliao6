package com;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Client {
    public static void main(String args[]) throws ParserConfigurationException, TransformerException, SAXException, ParseException, IOException {

        String inputFile = "com/"+args[0];

        String outputFile = "com/"+args[1];

        FileFormat fileFormat = new FileFormat();

        fileFormat.parse(inputFile, outputFile);

    }
}
