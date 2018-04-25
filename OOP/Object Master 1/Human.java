public class Human {
    private short strength, intelligence, stealth, health;

    public Human () {
        strength = 3;
        intelligence = 3;
        stealth = 3;
        health = 100;
    }

    public void attack (Human target) {
        target.takeDamage (strength);
    }

    public void takeDamage (short damage) {
        health -= damage;
    }

    public short getHealth () {
        return health;
    }

}