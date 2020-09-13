import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Character {
    private String gameCommand;
    int gameNPCS;
    boolean cheatmode;
    BST roomsBST;


    public Player(String name, String description) {
        this.characterName = name;
        this.cheatmode = false;
        this.characterDescription = description;


    }
    public void setgamenpcs(int a){
        this.gameNPCS = a;}


    public void runScanner(Scanner s) {
        //Scanner newScan = new Scanner(System.in);
        System.out.println("Input a command:");
        String gameCommand = s.nextLine();
        this.gameCommand = gameCommand;
    }

    protected String getGameCommand() {
        return this.gameCommand;
    }

    public String commandError() {
        return "Could not understand, please repeat";
    }


    public void play(Scanner s) {
        XMLparserMain.initTimer(60);
        XMLparserMain.incrementTime(5);
        Boolean activeGame = true;


        while (activeGame) {
            runScanner(s);

            if //(getGameCommand().matches("quit"|"exit"))
            (getGameCommand().equals("quit") || getGameCommand().equals("exit")) {
                activeGame = false;
            }
            else if (getGameCommand().equals("cheatmode")){
                this.cheatmode = true;
                System.out.println("You have entered the Matrix");
            }


            else if (getGameCommand().equals("look;all")) {
                if(cheatmode){
                    this.roomsBST.printTree();
                }
                else System.out.println("No Cheating!");




            }else if (getGameCommand().equals("look")) {
//look – this command immediately outputs to the user the complete information pertaining
// to the Room the Player is in (together with all Characters/Items in it).
                System.out.println(getLocationRoom());
                //System.out.println(this.roomsBST.search(getLocationRoom()));




            }else if (getGameCommand().contains("look: ")) {
                if(cheatmode){
                    int left = getGameCommand().indexOf(":");
                    String possibleRoomName = getGameCommand().substring(left + 2);
                    Room possibleRoom = new Room(possibleRoomName,"");
                    if (this.roomsBST.search(possibleRoom)!= null){
                        System.out.println(this.roomsBST.search(possibleRoom));}
                    else System.out.println("not a room");
                    }
                else System.out.println("no cheater");

            } else if (getGameCommand().equals("east")) {
                //"north, east, south, west – the Player leaves the current Room and enters its respective neighbor.
                // Be careful about special cases (no such neighbor, etc).
                // If the Player cannot execute the command for some reason,
                // provide according output to the user.\n" +
                //
                if (getLocationRoom().roomEast != null) {
                    //Room newRoom = getLocationRoom().roomEast;

                    //Character tempPlayerObject;

                    //tempPlayerObject = getLocationRoom().characterArray[i];
                    //System.out.println(tempPlayerObject);
                    getLocationRoom().removePlayer(this);
                    getLocationRoom().roomEast.setPlayer(this);
                    this.setLocationRoom(getLocationRoom().roomEast);
                    System.out.println("You have now entered " + getLocationRoom().getRoomName());




                    /*if (getLocationRoom().roomEast.addCharacter(this) {
                        getLocationRoom().removeCharacter(this);
                        setLocationRoom(getLocationRoom().roomEast);
                        System.out.println("You have now entered " + getLocationRoom().getRoomName());
                    } else {
                        System.out.println("Room is full!");
                    }*/
                } else {
                    System.out.println("Direction not available");
                }
            } else if (getGameCommand().equals("west")) {
                if (getLocationRoom().roomWest != null) {
                    getLocationRoom().removePlayer(this);
                    getLocationRoom().roomWest.setPlayer(this);
                    this.setLocationRoom(getLocationRoom().roomWest);

                    System.out.println("You have now entered " + getLocationRoom().getRoomName());

                    /*Room newRoom = getLocationRoom().roomWest;
                    //System.out.println(newRoom);
                    Character tempPlayerObject;
                    for (int i = 0; i < 5; i++) {
                        if (getLocationRoom().characterArray[i].getCharacterName().equals(getCharacterName())) {

                            tempPlayerObject = getLocationRoom().characterArray[i];
                            //System.out.println(tempPlayerObject);
                            if (newRoom.addCharacter(tempPlayerObject)) {
                                getLocationRoom().removeCharacter(tempPlayerObject);
                                setLocationRoom(newRoom);
                                System.out.println("You have now entered " + getLocationRoom().getRoomName());
                                break;
                            }
                        }
                    }*/
                } else {
                    System.out.println("Direction not available");
                }
            } else if (getGameCommand().equals("north")) {
                //"north, east, south, west – the Player leaves the current Room and enters its respective neighbor.
                // Be careful about special cases (no such neighbor, etc).
                // If the Player cannot execute the command for some reason,
                // provide according output to the user.\n" +
                //
                if (getLocationRoom().roomNorth != null) {
                    getLocationRoom().removePlayer(this);
                    getLocationRoom().roomNorth.setPlayer(this);
                    this.setLocationRoom(getLocationRoom().roomNorth);
                    System.out.println("You have now entered " + getLocationRoom().getRoomName());
                }
                    /*Room newRoom = getLocationRoom().roomNorth;

                    Character tempPlayerObject;
                    for (int i = 0; i < 5; i++) {
                        if (getLocationRoom().characterArray[i].getCharacterName().equals(getCharacterName())) {

                            tempPlayerObject = getLocationRoom().characterArray[i];
                            //System.out.println(tempPlayerObject);
                            if (newRoom.addCharacter(tempPlayerObject)) {
                                getLocationRoom().removeCharacter(tempPlayerObject);
                                setLocationRoom(newRoom);
                                System.out.println("You have now entered " + getLocationRoom().getRoomName());
                                break;
                            }
                        }


                    }
                }*/
                else {

                    System.out.println("Direction not available");

                }
            } else if (getGameCommand().equals("south")) {
                if (null != getLocationRoom().roomSouth) {
                    getLocationRoom().removePlayer(this);
                    getLocationRoom().roomSouth.setPlayer(this);
                    this.setLocationRoom(getLocationRoom().roomSouth);
                    System.out.println("You have now entered " + getLocationRoom().getRoomName());

                } else {
                    System.out.println("Direction not available");
                    System.out.println(commandError());
                }
            } else if (getGameCommand().equals("help")) {
                System.out.println("Command List:");
                System.out.println("help – this command outputs a help message to the user, consisting of the full list of commands that can be used, together with descriptions of what they do (run the example project for a possible help message).\n" +
                        "look – this command immediately outputs to the user the complete information pertaining to the Room the Player is in (together with all Characters/Items in it).\n" +
                        "north, east, south, west – the Player leaves the current Room and enters its respective neighbor. Be careful about special cases (no such neighbor, etc). If the Player cannot execute the command for some reason, provide according output to the user.\n" +
                        "shake:[itemname], possess:[itemname], throw:[itemname] – these commands allow manipulating the objects in the room, causing a reaction from the other Characters. Allow the user to type the actual item name, e.g., shake:white lamp.\n" +
                        "exit, quit – these commands print a “Goodbye” message and quit the program.");
            } else if (getGameCommand().contains(": ")) {
                int left = getGameCommand().indexOf(":");
                String possibleAction = getGameCommand().substring(0, left);
                String possibleItem = getGameCommand().substring(left + 2);
                if (possibleAction.matches("shake") ||
                        possibleAction.matches("possess") ||
                        possibleAction.matches("throw")) {
                    // matches vs equals strings
                    if (!possibleItem.isEmpty()) {


                        //String potentialItemCall = getGameCommand();
                        boolean realItem = true;
                        while (realItem) {
                            //int left1 = potentialItemCall.indexOf(":");
                            //String sub1 = potentialItemCall.substring(left1 + 2);
                            Random random = new Random();
                            for (int i = 0; i < getLocationRoom().itemArray.length; i++) {
                                if (getLocationRoom().itemArray[i] != null) {
                                    //System.out.println(getLocationRoom().itemArray[i].itemName+ "= " +sub1);
                                    if (getLocationRoom().itemArray[i].itemName.equals(possibleItem)) {
                                        if (possibleAction.equals("possess")) {
                                            if (getLocationRoom().itemArray[i].arrayCheck(Item.ItemActions.POSSESS)) {
                                                System.out.println(getLocationRoom().itemArray[i].itemName + " got possessed");

                                                int x = random.nextInt(15) + 10;
                                                //System.out.println("Scare created " + x);
                                                for (int b = 0; b < getLocationRoom().characterArray.length; b++) {
                                                    if (getLocationRoom().characterArray[b] != null) {

                                                        getLocationRoom().characterArray[b].addScareLevel(x);
                                                        System.out.println(getLocationRoom().characterArray[b].characterName + " shrieked");
                                                        if (getLocationRoom().characterArray[b].getScareLevel() > 99) {
                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " was removed from the house");
                                                            XMLparserMain.incrementTime(30);

                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                            this.gameNPCS = this.gameNPCS-1;
                                                            if (this.gameNPCS == 0){
                                                                System.out.println("you won");
                                                                activeGame = false;}
                                                        } else if (getLocationRoom().characterArray[b].getScareLevel() > 49) {
                                                            if(getLocationRoom().characterArray[b].initialroom == true){
                                                            boolean changedirection = true;
                                                            getLocationRoom().characterArray[b].initialroom =false;
                                                            while (changedirection) {
                                                                int rand2 = random.nextInt(4);
                                                                if (rand2 == 0) {
                                                                    if (getLocationRoom().roomWest != null) {
                                                                        if (getLocationRoom().roomWest.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomWest.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                } else if (rand2 == 1) {
                                                                    if (getLocationRoom().roomEast != null) {
                                                                        if (getLocationRoom().roomEast.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomEast.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                } else if (rand2 == 2) {
                                                                    if (getLocationRoom().roomNorth != null) {
                                                                        if (getLocationRoom().roomNorth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomNorth.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                        //if (getLocationRoom().characterArray[b].getScareLevel()>50)
                                                                    }
                                                                } else if (rand2 == 3) {
                                                                    if (getLocationRoom().roomSouth != null) {
                                                                        if (getLocationRoom().roomSouth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomSouth.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                }
                                                            }}

                                                        }
                                                    }
                                                }
                                                realItem = false;
                                                break;
                                            }
                                        }
                                            else if (possibleAction.equals("throw")) {
                                                if (getLocationRoom().itemArray[i].arrayCheck(Item.ItemActions.THROW)) {
                                                System.out.println(getLocationRoom().itemArray[i].itemName + " got thrown");
                                                getLocationRoom().itemArray[i].itemDescription = "this item has been destroyed";
                                                    getLocationRoom().itemArray[i].clean = false;
                                                for (int a = 0; a < getLocationRoom().itemArray[i].itemActionsArray.length; a++) {
                                                    getLocationRoom().itemArray[i].itemActionsArray[a] = null;
                                                }
                                                    int x = random.nextInt(20) + 20;
                                                    //System.out.println("Scare created " + x);
                                                    for (int b = 0; b < getLocationRoom().characterArray.length; b++) {
                                                        if (getLocationRoom().characterArray[b] != null) {

                                                            getLocationRoom().characterArray[b].addScareLevel(x);
                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " shrieked");
                                                            if (getLocationRoom().characterArray[b].getScareLevel() > 99) {
                                                                System.out.println(getLocationRoom().characterArray[b].characterName + " was removed from the house");
                                                                getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                XMLparserMain.incrementTime(30);
                                                                this.gameNPCS = this.gameNPCS-1;
                                                                if (this.gameNPCS == 0){
                                                                    System.out.println("you won");
                                                                    activeGame = false;
                                                                }
                                                            } else if (getLocationRoom().characterArray[b].getScareLevel() > 49) {
                                                                if(getLocationRoom().characterArray[b].initialroom == true){
                                                                    boolean changedirection = true;
                                                                    getLocationRoom().characterArray[b].initialroom =false;
                                                                while (changedirection) {
                                                                    int rand2 = random.nextInt(4);
                                                                    if (rand2 == 0) {
                                                                        if (getLocationRoom().roomWest != null) {
                                                                            if (getLocationRoom().roomWest.addCharacter(getLocationRoom().characterArray[b])) {
                                                                                System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomWest.roomName);
                                                                                getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                                changedirection = false;
                                                                            }
                                                                        }
                                                                    } else if (rand2 == 1) {
                                                                        if (getLocationRoom().roomEast != null) {
                                                                            if (getLocationRoom().roomEast.addCharacter(getLocationRoom().characterArray[b])) {
                                                                                System.out.println(getLocationRoom().characterArray[b] + " has gone to " + getLocationRoom().roomEast.roomName);
                                                                                getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                                changedirection = false;
                                                                            }
                                                                        }
                                                                    } else if (rand2 == 2) {
                                                                        if (getLocationRoom().roomNorth != null) {
                                                                            if (getLocationRoom().roomNorth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                                System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomNorth.roomName);
                                                                                getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                                changedirection = false;
                                                                            }
                                                                            //if (getLocationRoom().characterArray[b].getScareLevel()>50)
                                                                        }
                                                                    } else if (rand2 == 3) {
                                                                        if (getLocationRoom().roomSouth != null) {
                                                                            if (getLocationRoom().roomSouth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                                System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomSouth.roomName);
                                                                                getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                                changedirection = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                            }}
                                                        }
                                                    }

                                                realItem = false;
                                                break;
                                            }
                                        }
                                            else if (possibleAction.equals("shake")) {
                                            if (getLocationRoom().itemArray[i].arrayCheck(Item.ItemActions.SHAKE)) {
                                                System.out.println(getLocationRoom().itemArray[i].itemName + " got shook");
                                                int x = random.nextInt(11) + 5;
                                                //System.out.println("Scare created " + x);
                                                for (int b = 0; b < getLocationRoom().characterArray.length; b++) {
                                                    if (getLocationRoom().characterArray[b] != null) {

                                                        getLocationRoom().characterArray[b].addScareLevel(x);
                                                        System.out.println(getLocationRoom().characterArray[b].characterName + " shrieked");
                                                        if (getLocationRoom().characterArray[b].getScareLevel() > 99) {
                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " was removed from the house");
                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                            XMLparserMain.incrementTime(30);
                                                            this.gameNPCS = this.gameNPCS-1;
                                                            if (this.gameNPCS == 0){
                                                                System.out.println("you won");
                                                                activeGame = false;}
                                                        } else if (getLocationRoom().characterArray[b].getScareLevel() > 49) {
                                                            if(getLocationRoom().characterArray[b].initialroom == true){
                                                                boolean changedirection = true;
                                                                getLocationRoom().characterArray[b].initialroom =false;
                                                            while (changedirection) {
                                                                int rand2 = random.nextInt(4);
                                                                if (rand2 == 0) {
                                                                    if (getLocationRoom().roomWest != null) {
                                                                        if (getLocationRoom().roomWest.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomWest.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                } else if (rand2 == 1) {
                                                                    if (getLocationRoom().roomEast != null) {
                                                                        if (getLocationRoom().roomEast.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomEast.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                } else if (rand2 == 2) {
                                                                    if (getLocationRoom().roomNorth != null) {
                                                                        if (getLocationRoom().roomNorth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomNorth.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                        //if (getLocationRoom().characterArray[b].getScareLevel()>50)
                                                                    }
                                                                } else if (rand2 == 3) {
                                                                    if (getLocationRoom().roomSouth != null) {
                                                                        if (getLocationRoom().roomSouth.addCharacter(getLocationRoom().characterArray[b])) {
                                                                            System.out.println(getLocationRoom().characterArray[b].characterName + " has gone to " + getLocationRoom().roomSouth.roomName);
                                                                            getLocationRoom().removeCharacter(getLocationRoom().characterArray[b]);
                                                                            changedirection = false;
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                        }}
                                                    }
                                                }
                                                realItem = false;
                                                break;
                                            }
                                        }

                                            System.out.println(possibleAction + " not possible with " + possibleItem);
                                        realItem = false;
                                        break;
                                    }

                                }
                                else {
                                    System.out.println(possibleItem + " is not an availble item");
                                    realItem = false;
                                    break;


                                }


                                }



                            }

                        }
                    } else {
                        System.out.println(commandError());

                    }
                }

            else {
                System.out.println(commandError());
            }





        }
        System.out.println("Goodbye");
        System.exit(0);
    }
}