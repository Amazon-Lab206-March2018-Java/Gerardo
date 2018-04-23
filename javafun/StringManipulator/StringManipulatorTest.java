public class StringManipulatorTest {

    public static void main (String [] args) {
        StringManipulator manipulator = new StringManipulator ();

        System.out.println ( manipulator.trimAndConcat ("    Hello     ","     World    ") );
        System.out.println ( manipulator.getIndex ("Coding", "o") );
        System.out.println ( manipulator.getIndex ("123Dojoabc", "Dojo") );
        System.out.println ( manipulator.concatSubstring ("Hello", 1, 2, "world") );
    }
}