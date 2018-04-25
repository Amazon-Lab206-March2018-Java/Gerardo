class Gorilla extends Mammal {

    public Gorilla throwSomething () {
        System.out.println ("The Gorilla is angry and has thrown something! (lost 5 energy)");
        energyLevel -= 5;
        return this;
    }

    public Gorilla eatBananas () {
        System.out.println ("The Gorilla has eaten a banana and is smiling! (gained 10 energy)");
        energyLevel += 10;
        return this;
    }

    public Gorilla climb () {
        System.out.println ("The Gorilla has climbed a tree! (lost 10 energy)");
        energyLevel -= 10;
        return this;
    }
}