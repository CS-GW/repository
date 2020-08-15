public class Main {

    public static void main(String[] args) {


        Adult gilbert = new Adult("me","lazy");
        Adult g2 = new Adult("not me","programmer");
        Room bedroom = new Room("bed", "warm");

        bedroom.addAdult(gilbert);
        bedroom.addAdult(g2);



        System.out.println(bedroom);
        System.out.println(gilbert);







        //System.out.println(adulto.name + " in " + adulto.roomName +" " + bedroom.description + " " + gilbert.description);









    }
}