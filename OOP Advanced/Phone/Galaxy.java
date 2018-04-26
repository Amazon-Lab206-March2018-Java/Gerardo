public class Galaxy extends Phone implements Ringable {

    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    public String ring () {
        return "Galaxy " + versionNumber + " says " + ringTone;
    }

    public String unlock () {
        return "Unlocking via finger print scanner";
    }

    public void displayInfo () {
        System.out.println ("Galaxy " + versionNumber + " from " + carrier);
    }
    
}