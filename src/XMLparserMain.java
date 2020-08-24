import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.*;
public class XMLparserMain {
    ArrayList<Room> roomList = new ArrayList<>();

    Room playerStartingRoom;


    public Room getPlayerStartingRoom(){
        return playerStartingRoom;
    }




    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    static public void main(String[] args) throws Exception {
        ArrayList<Room> roomList = new ArrayList<>();
        Player playerPlayer = null;

        Room playerStartingRoom = null;


        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput = new FileInputStream("src/importXMLproject.xml");
            SAXParser saxParser = spf.newSAXParser();
            XMLparser sxp = new XMLparser();
            saxParser.parse(xmlInput, sxp);
            roomList = sxp.getRoomList();
            playerPlayer = sxp.getPlayer();
            playerStartingRoom = sxp.getPlayerLocation();


        }
        catch (SAXException | ParserConfigurationException | IOException anException) {
            anException.printStackTrace();
        }

        System.out.println(playerPlayer.characterName + " starts in " + playerPlayer.getLocationRoom().getRoomName() );

        playerPlayer.play();










    }

}
