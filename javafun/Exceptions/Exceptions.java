import java.util.ArrayList;

public class Exceptions {
    ArrayList<Object> list;
    
    public Exceptions () {
        this.list = new ArrayList<>();
    }

    public Exceptions addValue (Object val) {
        this.list.add(val);
        return this;
    }

    public void castValue (int index) {
        int var = 0;

        try {
            var = (Integer) this.list.get(index);
            System.out.println ("The parsed value is: " + var);
        } catch (ClassCastException e) {
            System.out.println ("ERROR ON INDEX: " + index);

        }
    }
}