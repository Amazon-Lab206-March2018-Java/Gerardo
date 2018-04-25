public class Dragon extends Mammal {
    
    public Dragon () {
        energyLevel = 300;
    }

    public Dragon fly () {
        System.out.println ("Wooooooshhhh!!!!");
        energyLevel -= 50;
        return this;
    }

    public Dragon eatHumans () {
        System.out.println ("Om nom nom nom~!");
        energyLevel += 25;
        return this;
    }

    public Dragon attackTown () {
        System.out.println ("* Sounds of a town on fire *");
        energyLevel -= 100;
        return this;
    }
}