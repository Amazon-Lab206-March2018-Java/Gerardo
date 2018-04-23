public class StringManipulator {
    
    public String trimAndConcat (String a, String b) {
        String newString = a.trim() + b.trim();
        
        return newString;
    }

    public Object getIndex (String string, char character) {
        int index = string.indexOf (character);
        if (index > -1) {
            return index;
        }
        return null;
    }

    public Object getIndex (String string, String subString) {
        int index = string.indexOf (subString);
        if (index > -1) {
            return index;
        }
        return null;
    }

    public String concatSubstring (String string1, int index1, int index2, String string2) {
        String subString = string1.substring (index1, index2);
        return subString + string2;
    }

}