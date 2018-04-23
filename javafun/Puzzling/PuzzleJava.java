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

    public void abc () {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random ();
        //shuffling
        for (int i = alphabet.length-1; i>0; i--) {
            //generate a random index
            int randomIndex = random.nextInt(i+1);

            char temp = alphabet[i];
            alphabet[i] = alphabet[randomIndex];
            alphabet[randomIndex] = temp;
        }

        System.out.println ("First letter: " + alphabet[0]);

        if ("aeiou".indexOf(alphabet[0])!= -1) {
            System.out.println ("The first letter in the array is a vowel!!! Weeee!!");
        }

        System.out.println ("Last letter: " + alphabet[alphabet.length-1]);
    }

    public int[] randomArray () {
        Random random = new Random();
        int[] array = new int[10];

        for (byte i = 0; i<array.length; i++) {
            int number = random.nextInt(45) + 56;
            array[i] = number;
        }
        return array;
    }

    public int[] randomArray2 () {
        Random random = new Random();
        int[] array = new int[10];
        int min, max;

        for (byte i = 0; i<array.length; i++) {
            int number = random.nextInt(45) + 56;
            array[i] = number;
        }
        Arrays.sort(array);
        return array;
    }

    public String randomString () {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String randomStr = "";

        Random random = new Random();

        for (byte i = 0; i<5; i++) {
            int index = random.nextInt(26);
            randomStr += alphabet.charAt(index);
        }

        return randomStr;
    }

    public void strArray () {
        String[] array = new String[10];
        
        for (byte i=0; i<10; i++) {
            array[i] = randomString();
        }

        System.out.println (Arrays.toString(array));
    }
}