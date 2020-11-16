package com;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class FileFormat {
    private FileParser fileParser;
    public void parse(String inputFile, String outputFile) throws ParserConfigurationException, ParseException, SAXException, IOException, TransformerException {
        String input_file_extension = inputFile.substring(inputFile.lastIndexOf(".") + 1).toLowerCase();
        String output_file_extension = outputFile.substring(outputFile.lastIndexOf(".") + 1).toLowerCase();
        if (inputFile.endsWith(".csv")) {
            fileParser = new CsvParser();
        } else if (inputFile.endsWith(".json")) {
            fileParser = new JsonParser();
        } else if (inputFile.endsWith(".xml")) {
            fileParser = new XmlParser();
        } else {
            System.out.println("Please Enter a Valid file type");
            return;
        }

        fileParser.getData(inputFile);

        File file = new File(outputFile);
        file.createNewFile();

        fileParser.processData(outputFile);

        }
    }

