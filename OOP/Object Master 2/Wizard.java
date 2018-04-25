public class Wizard extends Human {

    public Wizard () {
        health = 50;
        intelligence = 8;
    }

    public void heal (Human target) {
        target.setHealth ( target.getHealth() + intelligence );
    }

    public void fireball (Human target) {
        target.takeDamage (3*intelligence);
    }
}