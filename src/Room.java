public class Room implements Comparable<Room>{
    String roomName;
    String description;
    NPC[] characterArray;
    Player player;
    Room[] roomArray;
    Item[] itemArray;
    Room roomNorth;
    Room roomSouth;
    Room roomEast;
    Room roomWest;
    String north;
    String south;
    String west;
    String east;
    Integer roomCharacters;
    Room yo;


    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
        this.roomArray = new Room[4];
        this.characterArray = new NPC[5];
        this.player = player;
        this.itemArray = new Item[5];
        this.roomCharacters = 0;





    }

    @Override
    public int compareTo(Room room){
        if (this.roomName.toLowerCase().compareTo(room.roomName.toLowerCase()) > 0){
            return 1;
        } else if (this.roomName.toLowerCase().compareTo(room.roomName.toLowerCase()) == 0){
            return 0;
        } else {
            return -1;
        }
    }

    public boolean compareName(String roomName){
        return this.roomName.toLowerCase().equals(roomName.toLowerCase());
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void removePlayer(Player player){
        this.player = null;
    }

    public Room getroomEast(){
        if(roomEast !=null){
            return roomEast;
        }

        return null;
    }

    public String getRoomName() {
        return this.roomName;
    }


    public String toString() {
        String returnstring = "";
        returnstring += this.roomName + " " + this.description;

        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] != null) {

                returnstring += " \n"
                + characterArray[i];
            }
        }
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] != null) {

                returnstring += " \n"
                        + itemArray[i];
            }
        }



        return returnstring;

    }

    public boolean addCharacter(NPC characterA) {
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] == null) {
                characterArray[i] = characterA;
                characterA.setRoomName(getRoomName());
                roomCharacters++;
                for(int a = 0; a< itemArray.length;a++){
                    if (itemArray[a] != null) {
                        if (itemArray[a].clean == false) {
                            itemArray[a] = null;
                        }
                    }

                }
                //characterA.roomName = roomName;
                return true;
            }
        }
        return false;
    }
    public void removeCharacter(NPC characterA) {
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] != null){
                    if(characterArray[i].equals(characterA)){
                        characterArray[i] = null;
                        roomCharacters = roomCharacters -1;
                    }

            }
        }
    }
    public boolean addItem(Item itemA) {
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] == null) {
                itemArray[i] = itemA;
                return true;
            }
        }
        return false;
    }




}



