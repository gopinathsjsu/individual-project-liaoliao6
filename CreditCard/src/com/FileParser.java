package com;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface FileParser {
    void getData(String outputFile) throws IOException, ParseException, SAXException;

    void processData(String inputFile) throws IOException, TransformerException;

    void writeFile(String outputFile) throws TransformerException, IOException;
}
