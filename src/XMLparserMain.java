import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.*;
public class XMLparserMain {


    static public void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput = new FileInputStream("/Users/gilbert/Documents/CSC241/repository/src/importXMLproject.xml");
            SAXParser saxParser = spf.newSAXParser();
            XMLparser sxp = new XMLparser();
            saxParser.parse(xmlInput, sxp);
        }
        catch (SAXException | ParserConfigurationException | IOException anException) {
            anException.printStackTrace();
        }



    }




}
