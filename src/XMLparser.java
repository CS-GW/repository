import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



import java.util.ArrayList;

public class XMLparser extends DefaultHandler {
    ArrayList<Room> roomList = new ArrayList<>();
    Room playerLocation;
    String playaname;
    Player thaPlayaPlayer;
    String roomName1;
    String description;
    ArrayList charactergameArray;
    int gameNPCs;
    BST roomsBST;
    BST bstrooms = new BST();

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
    }

    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts) throws SAXException {
        BST bst = new BST();

           // System.out.println("Start Element " + qName);
        if (qName.equals("child")) {
            Child newChildA = new Child(atts.getValue("name"), atts.getValue("description"));
            roomList.get(roomCount).addCharacter(newChildA);

            gameNPCs++;

        }
        if (qName.equals("adult")) {
            Adult newAdultA = new Adult(atts.getValue("name"), atts.getValue("description"));
            roomList.get(roomCount).addCharacter(newAdultA);

            gameNPCs++;

        }
        if (qName.equals("player")) {
            Player player2 = new Player(atts.getValue("name"),atts.getValue("description"));
            roomList.get(roomCount).setPlayer(player2);
            player2.setLocationRoom(roomList.get(roomCount));
            thaPlayaPlayer = player2;


            playerLocation = roomList.get(roomCount);
            //System.out.println(playerLocation.roomName);
            //System.out.println(player2.characterName);




        }

        if (qName.equals("item")) {
            String itemName = atts.getValue("name");
            String itemDescription = atts.getValue("description");
            String itemActions = atts.getValue("actions");
            String[] itemActionsParsed = itemActions.split(",");
            //System.out.println(itemName);
            for(int i = 0;i<itemActionsParsed.length;i++){
                //System.out.println(itemActionsParsed[i]);
            }
            Item newItemA = new Item(itemName, itemDescription);
            for(int i = 0; i < itemActionsParsed.length; i++){
              if(itemActionsParsed[i].equals("throw")) {
                    newItemA.addItemAction(Item.ItemActions.THROW);
                }
                if(itemActionsParsed[i].contains("shake")){
                    newItemA.addItemAction(Item.ItemActions.SHAKE);
            }
                if(itemActionsParsed[i].contains("possess")){
                    newItemA.addItemAction(Item.ItemActions.POSSESS);
                }
            }

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
                room1.west = atts.getValue("west");
            }

            roomList.add(room1);
            bstrooms.insert(room1);
            //roomsBST.insert(room1);
            roomCount++;
        }

    }
    //description = atts.getValue("room", "description");

    //System.out.println(roomList);


    public void endElement(String namespaceURI,
                           String localName,
                           String qName) throws SAXException {

        if (qName.equals("room")) {
           // System.out.println("End Element " + roomList.get(0));
        }

    }

    public void endDocument() throws SAXException{

        for (int i = 0; i < roomCount; i++) {
            for (int a = 0; a < roomCount; a++) {
                if (roomList.get(a).roomName.equals(roomList.get(i).north)) {
                    roomList.get(i).roomNorth = roomList.get(a);
                }
                if (roomList.get(a).roomName.equals(roomList.get(i).south)) {
                    roomList.get(i).roomSouth = roomList.get(a);

                }
                if (roomList.get(a).roomName.equals(roomList.get(i).west)) {
                    roomList.get(i).roomWest = roomList.get(a);
                }
                if (roomList.get(a).roomName.equals(roomList.get(i).east)) {
                    roomList.get(i).roomEast = roomList.get(a);
                }
            }

        }
        for (int i = 0; i < roomCount; i++) {
            //System.out.println(roomList.get(i).getroomEast());
        }








    }
    public ArrayList getCharactergameArray() {return charactergameArray;}

    public ArrayList<Room> getRoomList(){
        return roomList;
    }
    public int getGameNPCs(){
        return gameNPCs;}





    public Room getPlayerLocation(){
        return playerLocation;
    }
    public BST getRoomsBST() {return bstrooms;}


    public Player getPlayer(){
        return thaPlayaPlayer;
    }


}
