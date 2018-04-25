public class DDTest {

    public static void main (String[] args) {

        Human pancho = new Human ();
        Wizard harry = new Wizard ();
        Ninja kamui = new Ninja ();
        Samurai nobunaga = new Samurai ();
        Samurai kenpachi = new Samurai ();

        pancho.attack(kenpachi);
        kenpachi.deathBlow (pancho);
        System.out.println ("kenpachi's health: " + kenpachi.getHealth() );
        System.out.println ("pancho's health: " + pancho.getHealth() );
        harry.heal(pancho);
        System.out.println ("kenpachi's health: " + kenpachi.getHealth() );
        harry.fireball (nobunaga);
        kamui.steal (kenpachi);
        kamui.runAway ();
        System.out.println ("nobunaga's health: " + nobunaga.getHealth() );
        System.out.println ("kenpachi's health: " + kenpachi.getHealth() );
        System.out.println ("kamui's health: " + kamui.getHealth() );

        System.out.println ("Amount of Samurai's: " + Samurai.howMany());


    }
}