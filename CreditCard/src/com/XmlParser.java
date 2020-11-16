package com;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Date;


public class XmlParser implements FileParser {
    private NodeList info;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    Document outputInfo;
    public XmlParser() throws ParserConfigurationException {
        info = new NodeList() {
            @Override
            public Node item(int index) {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }
        };

        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
    }

    @Override
    public void getData(String inputFile) throws IOException, SAXException {
            File file = new File(inputFile);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer =  new StringBuffer();
            String line = null;
            while((line = bufferedReader.readLine())!= null)
            {
                if(line.indexOf("&") != -1)
                {
                    line = line.replaceAll("&","");
                }
                String newline = System.getProperty("line.separator");
                stringBuffer.append(line).append(newline);
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputFile));
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.close();

            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            info = doc.getElementsByTagName("row");

    }

    @Override
    public void processData(String outputFile) throws TransformerException {

        InfoIterator iterator = new InfoIteratorImpl(info);
        outputInfo = documentBuilder.newDocument();

        Element root = outputInfo.createElement("root");
        outputInfo.appendChild(root);

        Element element;
        String cardNumber = "";
        String output;
        String cardType;
        String errorMessage = "None";

        for(;!iterator.isDone();) {
            element = (Element) iterator.currentNode();
            cardNumber = element.getElementsByTagName("CardNumber").item(0).getTextContent();
        }

        CreditCardFactory creditCardFactory = new SimpleCreditCardFactory();

        CreditCard creditCard = CreditCardFactory.createCard(cardNumber);

        if(creditCard==null){
            errorMessage = "Invalid card number";
            cardType = "Invalid";
        }

        output = creditCard.identifyCardType(cardNumber);

        if(output == "Invalid"){
            errorMessage = "Invalid card number";
        }
        cardType=output;

        Element row = outputInfo.createElement("row");
        root.appendChild(row);

        Element number = outputInfo.createElement("CardNumber");
        number.appendChild(outputInfo.createTextNode(cardNumber));
        row.appendChild(number);

        Element type = outputInfo.createElement("CardType");
        type.appendChild(outputInfo.createTextNode(cardType));
        row.appendChild(type);

        Element error = outputInfo.createElement("Error");
        error.appendChild(outputInfo.createTextNode(errorMessage));
        row.appendChild(error);

        iterator.goNext();

    this.writeFile(outputFile);

}

    @Override
    public void writeFile(String outputFile) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        outputInfo.setXmlStandalone(true);
        DOMSource domSource = new DOMSource(outputInfo);
        StreamResult streamResult = new StreamResult(new File(outputFile));

        transformer.transform(domSource, streamResult);
    }
}