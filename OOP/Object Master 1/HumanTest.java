public class HumanTest {

    public static void main (String[] args) {
        Human javier = new Human();
        Human victor = new Human();

        javier.attack (victor);
        System.out.println ( victor.getHealth() );
    }
}