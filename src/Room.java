public class Room {
    String roomName;
    String description;
    Character[] characterArray;
    Room[] roomArray;




    public Room(){

    }
    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
        this.roomArray = new Room[4];
        Adult[] adultArray = new Adult[5];
        this.characterArray = adultArray;
        for (int i = 0; i < adultArray.length; i++) {
        }
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


    public void addAdult(Adult adultA) {
        for (int i = 0; i<characterArray.length; i++) {
            if (characterArray[i] == null){
                characterArray[i] =adultA;
                adultA.roomName = roomName;
                break;
            }
        }
    }



}
