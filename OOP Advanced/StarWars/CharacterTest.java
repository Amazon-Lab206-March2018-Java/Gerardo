public class CharacterTest {

    public static void main (String[] args) {

        Character vader = new Character();
        Character chewbacca = new Character("Chewbacca", "RRRAARRWHHGWWR", 112);

        System.out.println ("[Vader's info] Name: "+vader.getName()+", Famous Saying: "+vader.getSaying()+", Weight: "+vader.getWeight() );
        System.out.println ("[Chewbacca's info] Name: "+chewbacca.getName()+", Famous Saying: "+chewbacca.getSaying()+", Weight: "+chewbacca.getWeight() );
        System.out.println ("");
        
        vader.setName ("Darth Vader");
        vader.setSaying ("I'm your father!");
        vader.setWeight (120);

        vader.greet(chewbacca);
    }
}