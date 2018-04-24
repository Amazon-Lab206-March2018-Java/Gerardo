public class HashmatiqueTest {
    public static void main (String [] args) {
        Hashmatique list = new Hashmatique();

        list.addSong ("Pancho1", "And there it was the awesome Pancho with his poncho");
        list.addSong ("Pancho2", "This is a tale of Pancho's adventures");
        list.addSong ("Pancho3", "Ayaayyyy, ayyyy, ayyyy, ayyyyy!!!");
        list.addSong ("Pancho4", "Yipaaa, yipaa, ayyyyy!!");

        System.out.println ( list.getSong ("Pancho2") );

        System.out.println ( list.getAll ());
    }
}