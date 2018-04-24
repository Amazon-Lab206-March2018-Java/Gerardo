

public class Project {
    private String name, description;

    public Project () {
        name = "";
        description = "";
    }

    public Project (String name) {
        this.name = name;
        description = "";
    }

    public Project (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String elevatorPitch () {
        return name + "," + description;
    }

    public String getName () {
        return name;
    }

    public void setName (String _name) {
        name = _name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String _description) {
        description = _description;
    }
}