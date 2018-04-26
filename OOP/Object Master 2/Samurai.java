public class Samurai extends Human {

    private static int samuraiAmount = 0;

    public Samurai () {
        setHealth(200);
        samuraiAmount++;
    }

    public void deathBlow (Human target) {
        target.takeDamage ( target.getHealth() );
        health = health/2;
    }

    public void meditate () {
        health += health/2;
    }

    public static int howMany () {
        return samuraiAmount;
    }

}