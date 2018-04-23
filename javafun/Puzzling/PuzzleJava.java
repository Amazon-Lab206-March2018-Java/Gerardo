import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
// import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> puzzle1 () {

        ArrayList<Integer> output = new ArrayList<Integer>();        
        int [] array = {3,5,1,2,7,9,8,13,25,32};
        short total = 0;

        for (short i = 0; i<array.length; i++) {
            total += array[i];
            if (array[i] > 10) {
                output.add(array[i]);
            }
        }
        System.out.println ("Total: " + total);
        return output;
    }

    public ArrayList<String> shuffle () {
        String [] array = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};

        Random random = new Random ();
        String temp = "";
        ArrayList<String> output = new ArrayList<String>();
        //shuffles the array
        for (int i = array.length-1; i>0; i--) {
            //generate a random index
            int randomIndex = random.nextInt(i+1);

            temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }

        for (int i = 0;  i<array.length; i++) {
            if (array[i].length() > 5) {
                output.add(array[i]);
            }
        }
        System.out.println ("All names: " + Arrays.toString (array));
        return output;
    }
}