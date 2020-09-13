import org.xml.sax.SAXException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.*;
public class XMLparserMain {

    private static Timer timer;
    private static AtomicInteger timeLeft;
    public static void initTimer(int secs){
        timeLeft = new AtomicInteger(secs);
        TimerTask task = new TimerTask() {
            @Override
            public void run(){
                int tl = timeLeft.decrementAndGet();
                if (tl == 0){
                    System.out.println("Game Over: Out of time");
                    System.exit(0);
                }
            }
        };

        timer = new Timer();
        timer.schedule(task, 0, 1000);
    }

    public static void incrementTime(int time){
        timeLeft.getAndAdd(time);
    }



    static public void main(String[] args) throws Exception {
        ArrayList<Room> roomList = new ArrayList<>();

        Player gamePlayer = null;
        ArrayList gameNPCsArray;
        int gameNPCsInt;


        Scanner s = new Scanner(System.in);

        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput = new FileInputStream("src/importXMLproject.xml");
            SAXParser saxParser = spf.newSAXParser();
            XMLparser sxp = new XMLparser();
            saxParser.parse(xmlInput, sxp);
            gamePlayer = sxp.getPlayer();
            gamePlayer.roomsBST = sxp.getRoomsBST();
            gamePlayer.gameNPCS = sxp.getGameNPCs();





        }
        catch (SAXException | ParserConfigurationException | IOException anException) {
            anException.printStackTrace();
        }
        System.out.println(gamePlayer.characterName + " is playing, starting in the " + gamePlayer.getLocationRoom().getRoomName());
        gamePlayer.play(s);
    }

}
