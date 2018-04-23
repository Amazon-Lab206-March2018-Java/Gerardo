import java.util.Arrays;

public class BasicTest {

    public static void main (String [] args) {

        Basic execute = new Basic();

        execute.oneTo255 ();
        execute.odd1to255 ();
        execute.sum();
        System.out.println ("---> RUNARRAY:");
        execute.runArray(new int [] {1,2,3,4,5});
        System.out.println ("---> MAX:");
        execute.max(new int [] {1,2,3,-1,0});
        System.out.println ("---> GETAVG:");
        execute.getAvg(new int [] {1,2,3});
        System.out.println ("---> ODDARRAY:");
        execute.oddArray();
        System.out.println ("---> GREATERTHANY:");
        System.out.println (execute.greaterThanY(new int [] {1,2,3,-1,0}, 2) );
        System.out.println ("---> SQUARE:");
        execute.square(new int [] {1,2,3});
        System.out.println ("---> REMOVE NEGATIVES:");
        execute.removeNegatives(new int [] {1,2,3,-1,-7});
        System.out.println ("---> MIN MAX AVG:");
        System.out.println (Arrays.toString( execute.minMaxAvg(new int [] {1,1,2,2,3,3}) ) );
        System.out.println ("---> ARRAY SHIFT:");
        execute.arrayShift(new int [] {1,2,3,4});
    }
}