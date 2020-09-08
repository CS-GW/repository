import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    private Timer timer;
    private static AtomicInteger timeLeft;






    public static void main(String[] args) {

        public void initTimer(int secs){
            timeLeft = new AtomicInteger(secs);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    int tl = timeLeft.decrementAndGet();
                    if (tl == 0) {
                        System.out.println("youss loost the game");
                        // Add code to tell the user they lost and to exit the game.
                    }
                }
            };
            //initTimer(20);
            timeLeft.addAndGet(20);

            //timer = new Timer();

            //timer.schedule(task, 0, 1000);
        }


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