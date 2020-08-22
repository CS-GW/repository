import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



import java.util.ArrayList;

public class XMLparser extends DefaultHandler {
    ArrayList<Room> roomList;
    String roomName1;
    String description;
    String localname1;
    String localname2;
    String localname3;
    String uri1;
    String qname1;
    Character[] characterArray;
    Room[] roomArray;
    String roomNorth;
    String roomSouth;
    String roomEast;
    String roomWest;
    String characterName;
    String characterDescription;
    int roomCount = -1;

    public void startDocument() throws SAXException {
        roomList = new ArrayList<>();
    }

    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts) throws SAXException {

            System.out.println("Start Element " + qName);
        if (qName.equals("child")) {
            Child newChildA = new Child(atts.getValue("name"), atts.getValue("description"));
            roomList.get(roomCount).addCharacter(newChildA);

        }
        if (qName.equals("adult")) {
            Adult newAdultA = new Adult(atts.getValue("name"), atts.getValue("description"));
            roomList.get(roomCount).addCharacter(newAdultA);

        }
        if (qName.equals("player")) {
            Player player2 = new Player();
            player2.characterName = atts.getValue("name");
            player2.characterDescription = atts.getValue("description");
            roomList.get(roomCount).addCharacter(player2);
        }

        if (qName.equals("item")) {
            String itemName = atts.getValue("name");
            String itemDescription = atts.getValue("description");
            String itemActions = atts.getValue("actions");
            String[] itemActionsParsed = itemActions.split(", ");
            Item newItemA = new Item(itemName, itemDescription);
            //for(int i = 0; i < itemActionsParsed.length; i++){
              //  if(itemActionsParsed(i).contains

                //        .ItemActions.POSSESS
            //}





            roomList.get(roomCount).addItem(newItemA);

        }
        if (qName.equals("room")) {
            roomName1 = atts.getValue("name");
            description = atts.getValue("description");
            Room room1 = new Room(roomName1, description);
            if (atts.getValue("north") != null) {
                room1.north = atts.getValue("north");
                //System.out.println(roomNorth);
            }
            if (atts.getValue("south") != null) {
                room1.south = atts.getValue("south");
            }
            if (atts.getValue("east") != null) {
                room1.east = atts.getValue("east");
            }
            if (atts.getValue("west") != null) {
                room1.south = atts.getValue("west");
            }

            roomList.add(room1);
            roomCount++;
        }
    }
    //description = atts.getValue("room", "description");

    //System.out.println(roomList);


    public void endElement(String namespaceURI,
                           String localName,
                           String qName) throws SAXException {

        if (qName.equals("room")) {
            System.out.println("End Element " + roomCount);
        }

    }

    public void roomDirectionMap() {
        for (int i = 0; i < roomCount; i++) {
            for (int a = 0; a < roomCount; a++) {
                if (roomList.get(a).roomName.contains(roomList.get(i).north)) {
                    roomList.get(i).roomNorth = roomList.get(a);
                }
                if (roomList.get(a).roomName.contains(roomList.get(i).south)) {
                    roomList.get(i).roomSouth = roomList.get(a);

                }
                if (roomList.get(a).roomName.contains(roomList.get(i).west)) {
                    roomList.get(i).roomWest = roomList.get(a);
                }
                if (roomList.get(a).roomName.contains(roomList.get(i).east)) {
                    roomList.get(i).roomEast = roomList.get(a);
                }
            }
        }
        for (int i = 0; i < roomCount; i++) {
            System.out.println(roomList.get(i).getroomEast());
        }
    }

}
