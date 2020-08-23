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

        ArrayList<Room> roomList = new ArrayList<>();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput = new FileInputStream("src/importXMLproject.xml");
            SAXParser saxParser = spf.newSAXParser();
            XMLparser sxp = new XMLparser();
            saxParser.parse(xmlInput, sxp);
            roomList = sxp.getRoomList();
            System.out.println(roomList);


        }
        catch (SAXException | ParserConfigurationException | IOException anException) {
            anException.printStackTrace();
        }
        System.out.println("Space holder");
        System.out.println("Space holder");



    }




}
