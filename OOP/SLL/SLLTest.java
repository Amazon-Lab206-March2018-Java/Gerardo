public class SLLTest {
    public static void main (String [] args) {
        SLL list = new SLL();

        list.add(1).add(2).add(3);
        list.printValues();
        list.remove().printValues();
    }
}