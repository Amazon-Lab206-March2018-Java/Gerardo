public class ExceptionsTest {

    public static void main (String[] args) {
        Exceptions ex = new Exceptions();

        ex.list.add("13");
        ex.list.add("hello world");
        ex.list.add(48);
        ex.list.add("Goodbye World");

        int var = 0;
        
        for (byte i = 0; i<ex.list.size(); i++) {
            ex.castValue (i);
        }
    }
}