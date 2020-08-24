public class Room {
    String roomName;
    String description;
    Character[] characterArray;
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
    Room yo;


    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
        this.roomArray = new Room[4];
        this.characterArray = new Character[5];
        this.itemArray = new Item[10];





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
                //Character aduulo = this.characterArray[i];
                returnstring += " " + characterArray[i];
            }
        }
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] != null) {
                //Item aduulo = this.itemArray[i];
                returnstring += " " + itemArray[i];
            }
        }



        return returnstring;

    }

    public boolean addCharacter(Character characterA) {
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] == null) {
                characterArray[i] = characterA;
                characterA.setRoomName(getRoomName());
                //characterA.roomName = roomName;
                return true;
            }
        }
        return false;
    }
    public void removeCharacter(Character characterA) {
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] != null){
                    if(characterArray[i].equals(characterA)){
                        characterArray[i] = null;
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



