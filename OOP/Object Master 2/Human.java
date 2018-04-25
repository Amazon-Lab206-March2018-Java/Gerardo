public class Human {
    protected int strength, intelligence, stealth, health;

    public Human () {
        strength = 3;
        intelligence = 3;
        stealth = 3;
        health = 100;
    }

    public void attack (Human target) {
        target.takeDamage (strength);
    }

    public void takeDamage (int damage) {
        health -= damage;
    }

    public int getHealth () {
        return health;
    }

    public void setHealth (int amount) {
        health = amount;
    }

    public void printStats () {
        System.out.println ("strength: " + strength + " intelligence: " + intelligence
                            + " stealth: " + stealth + " health: " + health);
    }
}