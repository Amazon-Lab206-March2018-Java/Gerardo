import java.util.Arrays;
//import java.util.ArrayList;

public class PuzzleJavaTest {
    
    public static void main (String [] args) {

        PuzzleJava execute = new PuzzleJava();

        System.out.println ( "Numbers higher than 10: " + execute.puzzle1() );
        System.out.println ( "Names longer than 5: " + execute.shuffle() );
        execute.abc();
        System.out.println (Arrays.toString (execute.randomArray()) );

        int[] array = execute.randomArray2();
        System.out.println (Arrays.toString (array) );
        System.out.println ("Min: " + array[0] + " Max: " + array[array.length-1]);

        System.out.println ( execute.randomString() );

        execute.strArray();
    }
}