
public class Character {
    String characterName;
    String characterDescription;
    private String roomName;

    public Character(){

    }
    public Character(String Name, String Description) {
        this.characterName = Name;
        this.characterDescription = Description;
    }

    public String getRoomName() {
        return this.roomName;
    }

    protected void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public String getCharacterDescription() {
        return this.characterDescription;
    }
    public String toString() {
        return this.characterName + " " + this.characterDescription;
    }


}