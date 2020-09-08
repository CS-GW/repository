public class Child extends NPC {
    public Child(String name, String description) {
        this.characterName = name;
        this.characterDescription = description;


    }
    public void addScareLevel(int i){
        i = i*3;
        i = i/2;
        this.scareLevel = scareLevel + (i);
    }




    public String toString() {
        return this.characterName + " " + this.characterDescription + this.scareLevel;

    }
}
