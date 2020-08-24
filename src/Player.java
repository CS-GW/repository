import java.util.Scanner;

public class Player extends Character {
    private String gameCommand;

    public Player(String name, String description) {
        this.characterName = name;
        this.characterDescription = description;
    }

    public void runScanner() {
        Scanner newScan = new Scanner(System.in);
        System.out.println("Input a command:");
        String gameCommand = newScan.nextLine();
        this.gameCommand = gameCommand;
    }

    protected String getGameCommand() {
        return this.gameCommand;
    }


    public void play() {
        Boolean activeGame = true;

        while (activeGame) {
            runScanner();
            if //(getGameCommand().matches("quit"|"exit"))
            (getGameCommand().equals("quit")||getGameCommand().equals("exit"))
            {
                activeGame = false;
            }
            else if (getGameCommand().equals("look")) {
//look – this command immediately outputs to the user the complete information pertaining
// to the Room the Player is in (together with all Characters/Items in it).
                System.out.println(getLocationRoom());

            }
            else if (getGameCommand().equals("east")) {
                //"north, east, south, west – the Player leaves the current Room and enters its respective neighbor.
                // Be careful about special cases (no such neighbor, etc).
                // If the Player cannot execute the command for some reason,
                // provide according output to the user.\n" +
                //
                if (getLocationRoom().roomEast != null) {
                    Room newRoom = getLocationRoom().roomEast;

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
                } else {
                    System.out.println("Direction not available");

                }
            }
            else if (getGameCommand().equals("west")) {
                if (getLocationRoom().roomWest != null) {

                    Room newRoom = getLocationRoom().roomWest;
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
                    }
                }
                else {
                    System.out.println("Direction not available");
                }
            }
            else if (getGameCommand().equals("north")) {
                //"north, east, south, west – the Player leaves the current Room and enters its respective neighbor.
                // Be careful about special cases (no such neighbor, etc).
                // If the Player cannot execute the command for some reason,
                // provide according output to the user.\n" +
                //
                if (getLocationRoom().roomNorth != null) {
                    Room newRoom = getLocationRoom().roomNorth;

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
                } else {
                    System.out.println("Direction not available");

                }
            }
            else if (getGameCommand().equals("south")) {
                if (null != getLocationRoom().roomSouth) {

                    Room newRoom = getLocationRoom().roomSouth;
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


                    }
                }
                else {
                    System.out.println("Direction not available");

                }
            }
                else if (getGameCommand().equals("help")) {
                    System.out.println("Command List:");
                    System.out.println("help – this command outputs a help message to the user, consisting of the full list of commands that can be used, together with descriptions of what they do (run the example project for a possible help message).\n" +
                            "look – this command immediately outputs to the user the complete information pertaining to the Room the Player is in (together with all Characters/Items in it).\n" +
                            "north, east, south, west – the Player leaves the current Room and enters its respective neighbor. Be careful about special cases (no such neighbor, etc). If the Player cannot execute the command for some reason, provide according output to the user.\n" +
                            "shake:[itemname], possess:[itemname], throw:[itemname] – these commands allow manipulating the objects in the room, causing a reaction from the other Characters. Allow the user to type the actual item name, e.g., shake:white lamp.\n" +
                            "exit, quit – these commands print a “Goodbye” message and quit the program.");
                }
                else if(getGameCommand().contains("shake")||
                    getGameCommand().contains("possess")
            




            ){
                    System.out.println("do nutin");

                    //"shake:[itemname], possess:[itemname], throw:[itemname] –
                // these commands allow manipulating the objects in the room, causing a reaction from the other Characters.
                // Allow the user to type the actual item name, e.g., shake:white lamp.\n" +
            }
                else {
                    System.out.println("Could not understand, please repeat");
                }
            }
            System.out.println("Goodbye");
        }
    }


