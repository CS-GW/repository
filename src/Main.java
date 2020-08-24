

import java.util.Scanner;

public class Main {




    public static void main(String[] args) {


        Adult gilbert = new Adult("me","lazy");

        Adult g2 = new Adult("not me","programmer");
        Room bedroom = new Room("bed", "warm");
        Item rock = new Item("rock", "heavy");
        Room redroom = new Room("snow","on da bluff");

        Room checkRoom = new Room("Kitchen", "A place for cooking");
        Character vincent = new Adult("Vincent", "Balding");
        Character gilbert2 = new Adult("Gilbert", "Programmer");
        checkRoom.addCharacter(gilbert);

        checkRoom.addCharacter(gilbert);
        checkRoom.addCharacter(vincent);
        checkRoom.removeCharacter(vincent);
        System.out.println(checkRoom);

























        /*
        System.out.println(vincent);
        System.out.println(gilbert2);

        checkRoom.addCharacter(vincent);
        checkRoom.addCharacter(gilbert2);

        System.out.println(vincent);
        System.out.println(gilbert2);

        System.out.println(checkRoom);

         */



        /*
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

         */
    }
}