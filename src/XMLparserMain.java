import org.xml.sax.SAXException;

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

        Player gamePlayer = null;

        Scanner s = new Scanner(System.in);





        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput = new FileInputStream("src/importXMLproject.xml");
            SAXParser saxParser = spf.newSAXParser();
            XMLparser sxp = new XMLparser();
            saxParser.parse(xmlInput, sxp);
            gamePlayer = sxp.getPlayer();



        }
        catch (SAXException | ParserConfigurationException | IOException anException) {
            anException.printStackTrace();
        }
        System.out.println(gamePlayer.characterName + " is playing, starting in the " + gamePlayer.getLocationRoom().getRoomName());
        gamePlayer.play(s);










    }

}
