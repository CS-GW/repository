public class Adult extends NPC {
    //String name;
    //String description;
    //String roomName;


    public Adult(String name, String description){
        this.characterName = name;
        this.characterDescription = description;
    }
    //public int getScareLevel() {
        //return scareLevel;
    //}

    //public void addScareLevel(int i){
        //this.scareLevel = scareLevel+ i;
    //}


    public String toString() {
        return this.characterName + " " + this.characterDescription + " scaredlevel: " + this.scareLevel;


        //ArrayList yo = new ArrayList();
        //yo.add(this.name);
        //yo.add(this.description);
        //return yo;





    }



}
