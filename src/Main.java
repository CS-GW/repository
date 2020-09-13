import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {


    private static Timer timer;
    private static AtomicInteger timeLeft;


    public static void initTimer(int secs){
        timeLeft = new AtomicInteger(secs);
        TimerTask task = new TimerTask() {
            @Override
            public void run(){
                int tl = timeLeft.decrementAndGet();
                if (tl == 0){
                    System.out.println("Game Over");
                    System.exit(0);
                }
            }
        };

        timer = new Timer();
        timer.schedule(task, 0, 1000);
    }

    public static void incrementTime(int time){
        timeLeft.getAndAdd(time);
    }




    //private static BST yaHeard;
    sll drama;


    public static void main(String[] args){
        BST bsss = null;
        Room room8 = new Room("yo","uo");
        bsss.insert(room8);
        bsss.printTree();

        sll drama1 = new sll("hello");

        drama1.insert("hello2", 0);
        drama1.insert("hello3", 1);
        drama1.append("hello");
        drama1.insert("hellome",-1);
        System.out.println(drama1);

        //BST yaHeard = new BST();
        /*
        yaHeard.insert(50);
        yaHeard.printInOrder();
        yaHeard.insert(2);
        yaHeard.insert(3);
        yaHeard.printInOrder();
        yaHeard.insert(4);
        yaHeard.insert(100);
        yaHeard.printInOrder();

        yaHeard.insert(62);
        yaHeard.printInOrder();

        yaHeard.printTree();
*/


        /*
        timerExample te = new timerExample();
        te.starTimer(3);
        */
        /* could do things like
        timeLeft.get();
        timeLeft.set(timeLeft.get() + 50);
         */
        //Main.initTimer(5);
        //Main.incrementTime(5);

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