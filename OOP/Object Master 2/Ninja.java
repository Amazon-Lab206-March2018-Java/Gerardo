public class Ninja extends Human{

    public Ninja () {
        stealth = 10;
    }

    public void steal (Human target) {
        target.takeDamage (stealth);
        health += stealth;
    }

    public void runAway () {
        health -= 10;
    }
}