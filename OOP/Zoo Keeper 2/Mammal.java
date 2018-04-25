public class Mammal {
    protected short energyLevel;

    Mammal () {
        energyLevel = 100;
    }

    public short displayEnergy () {
        System.out.println ("Current energy level: " + energyLevel);
        return energyLevel;
    }
}