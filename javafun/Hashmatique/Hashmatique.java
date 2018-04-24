import java.util.HashMap;
import java.util.Collection;

public class Hashmatique {
    private HashMap<String, String> trackList;
    
    public Hashmatique () {
        this.trackList = new HashMap<>();
    }
    
    public Hashmatique addSong (String title, String lyrics) {
        this.trackList.put (title, lyrics);
        return this;
    }

    public String getSong (String title) {
        return this.trackList.get(title);
    }

    public Collection getAll() {
        return trackList.values();
    }

}