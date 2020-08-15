public class Room {
    String roomName;
    String description;
    Character[] characterArray;
    Room[] roomArray;


    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
        this.roomArray = new Room[4];
        this.characterArray = new Character[5];
    }

    public String toString() {
        String returnstring = "";
        returnstring = returnstring + this.roomName +" "+ this.description;

        for(int i=0;i<characterArray.length; i++){
            if(characterArray[i] != null ){
                Character aduulo = this.characterArray[i];
                returnstring = returnstring+ " " + (aduulo.toString());
            }
        }
        return returnstring;

    }


    public void addCharacter(Character characterA) {
        for (int i = 0; i<characterArray.length; i++) {
            if (characterArray[i] == null){
                characterArray[i] =characterA;
                characterA.roomName = roomName;
                break;
            }
        }
    }



}
