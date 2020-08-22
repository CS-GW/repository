public class Main {

    public static void main(String[] args) {


        Adult gilbert = new Adult("me","lazy");
        Adult g2 = new Adult("not me","programmer");
        Room bedroom = new Room("bed", "warm");
        Item rock = new Item("rock", "heavy");
        Room redroom = new Room("snow","on da bluff");

        Player billya = new Player();
        billya.characterName = "joe";
        billya.characterDescription = "numbnuts";
        redroom.addCharacter(billya);
        bedroom.addCharacter(gilbert);
        bedroom.addCharacter(g2);
        bedroom.addItem(rock);
        redroom.addItem(rock);
        redroom.addCharacter(g2);
        System.out.println(bedroom.roomName);
        System.out.println(bedroom);
        bedroom.roomEast = redroom;
        System.out.println(bedroom.roomEast);
    }
}