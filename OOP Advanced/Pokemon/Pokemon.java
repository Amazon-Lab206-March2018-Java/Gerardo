public class Pokemon {
    private String name, type;
    private int health;
    private static short count = 0;

    public Pokemon (String _name, int _health, String _type) {
        name = _name;
        health = _health;
        type = _type;
    }

    public void setName (String _name) {
        name = _name;
    }
    
    public void setHealth (int _health) {
        health = _health;
    }

    public void setType (String _type) {
        type = _type;
    }

    public String getName () {
        return name;
    }

    public int getHealth () {
        return health;
    }

    public String getType () {
        return type;
    }

    public static short getCount () {
        return count;
    }
}