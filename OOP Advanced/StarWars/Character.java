public class Character {
    private String name, saying;
    private int weight;

    public Character () {
        name = "RandomCharacters";
        saying = "weeeeeeee!";
        weight = 0;
    }

    public Character (String name, String saying, int weight) {
        this.name = name;
        this.saying = saying;
        this.weight = weight;
    }

    public void greet (Character character) {
        System.out.println ("Hello "+character.getName()+", I'm "+name);
        System.out.println ("And "+saying);
    }

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getSaying () {
        return saying;
    }
    public void setSaying (String saying) {
        this.saying = saying;
    }
    public int getWeight () {
        return weight;
    }
    public void setWeight (int weight) {
        this.weight = weight;
    }
}