public class PhoneTester {

    public static void main (String[] args) {
        IPhone iphone = new IPhone("X", 100, "AT&T", "Zing");
        Galaxy galaxy = new Galaxy("Note 8", 100, "Verizon", "Ring Ring Ring!");

        galaxy.displayInfo();
        System.out.println (galaxy.ring());
        System.out.println (galaxy.unlock());

        iphone.displayInfo();
        System.out.println (iphone.ring());
        System.out.println (iphone.unlock());
    }
}