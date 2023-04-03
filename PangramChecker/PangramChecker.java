

public class PangramChecker {
    public boolean check(String sentence){
        String lowercase = sentence.toLowerCase();
        // a-z = 97-122
        // Loop through sentence till letter found
        for (int letter=97; letter < 123; letter++) {
            for (int i=0; i <= lowercase.length(); i++) {
            
                // If at last and still not found end Program
                if (i == lowercase.length()) {
                    return false;
                }
                
                // Check only letters
                if (Character.isLetter(lowercase.charAt(i))) {
                    
                    // If letter found break and move to the next
                    if ((int) lowercase.charAt(i) == letter) {
                        break;
                    } 
                }
            }
        }
        return true;
    }
}