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
        returnstring = returnstring + this.roomName + " " + this.description;

        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] != null) {
                Character aduulo = this.characterArray[i];
                returnstring = returnstring + " " + (aduulo.toString());
            }
        }
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] != null) {
                Item aduulo = this.itemArray[i];
                returnstring = returnstring + " " + (aduulo.toString());
            }
        }



        return returnstring;

    }

    public void addCharacter(Character characterA) {
        for (int i = 0; i < characterArray.length; i++) {
            if (characterArray[i] == null) {
                characterArray[i] = characterA;
                characterA.characterName = getRoomName();
                //characterA.roomName = roomName;
                break;
            }
        }
    }

    public void addItem(Item itemA) {
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] == null) {
                itemArray[i] = itemA;
                break;
            }
        }
    }

    public void moveCharacter(Character characterA) {
        //...
    }


}



