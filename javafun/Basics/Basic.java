import java.util.ArrayList;
import java.util.Arrays;

public class Basic {

    public void oneTo255 () {
        for (short i = 0; i<256; i++) {
            System.out.println (i);
        }
    }

    public void odd1to255 () {
        for (short i = 1; i<256; i+=2) {
            System.out.println (i);
        }
    }

    public void sum () {
        short totalSum = 0;
        for (short i = 1; i<256; i+=2) {
            totalSum += i;
            System.out.println ("Current number: " + i + " Total sum: " + totalSum);
        }
    }
    
    public void runArray (int [] arr) {
        for (short i = 0; i<arr.length; i++) {
            System.out.println (arr[i]);
        }
    }

    public void max (int [] arr) {
        int max = arr[0];
        for (short i = 1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println (max);
    }

    public void getAvg (int [] arr) {
        int avg = 0;
        for (short i = 0; i<arr.length; i++) {
            avg += arr[i];
        }
        avg /= arr.length;
        System.out.println (avg);
    }

    public void oddArray () {
        ArrayList<Short> array = new ArrayList<Short>();

        for (short i = 1; i<=255; i+=2) {
            array.add(i);
        }
        System.out.println (array);
    }

    public short greaterThanY (int [] array, int y) {
        short count = 0;
        for (int element : array) {
            if (element > y) {
                count++;
            }
        }
        return count;
    }

    public void square (int [] array){
        for (int i = 0; i<array.length; i++) {
            array[i] *= array[i];
        }
        System.out.println (Arrays.toString(array));
    }

    public void removeNegatives (int [] array) {
        for (int i = 0; i<array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
        System.out.println (Arrays.toString(array));
    }

    public int[] minMaxAvg (int [] arr) {
        int min = arr[0];
        int max = arr[0];
        int avg = arr[0];
        for (short i = 1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            else if (arr[i] < min) {
                min = arr[i];
            }
            avg += arr[i];
        }
        avg /= arr.length;
        return new int[] {min, max, avg};
    }

    public void arrayShift (int [] arr) {
        for (short i = 0; i<arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;

        System.out.println (Arrays.toString(arr));
    }
}