public class Child extends NPC {
    public Child(String name, String description) {
        this.characterName = name;
        this.characterDescription = description;
    }


    public String toString() {
        return this.characterName + " " + this.characterDescription;

    }
}
