public class Basic {

    public void 1to255 () {
        for (short i = 0; i<256; i++) {
            System.out.println (i);
        }
    }

    public void odd1t0255 () {
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
    
    public void runArray (arr) {
        for (short i = 0; i<arr.length(); i++) {
            System.out.println (i);
        }
    }

    public void max (arr) {
        int max = arr[0];
        for (short i = 1; i<arr.length(); i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println (max);
    }
}