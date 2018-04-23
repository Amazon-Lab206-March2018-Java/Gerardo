public class FizzBuzz {
    public void check (int value) {
        if (value%3 == 0 && value%5 == 0) {
            System.out.println ("FizzBuzz");
        } else if (value%3 == 0) {
            System.out.println ("Fizz");
        } else if (value%5 == 0) {
            System.out.println ("Buzz");
        } else {
            System.out.println ("Number: " + value);
        }
    }
}