/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmatching;

/**
 *
 * @author will2
 */
public class RabinKarp {
    public String string;
    public String pattern;
    public int hash_string;
    public int hash_pattern;
    public int length_string;
    
    
    public RabinKarp(){
        
    }
    
    public void RabinKarpSearch(String userString, String userPattern, int mod) {
        int stringLength = userString.length();
        int patternLength = userPattern.length();
        int stringHash = 0;
        int patternHash = 0;
        int h = 1;
        int maxChar = 256; //the MAX number of characters in the input alphabet 
        
        int i; //used for the for loops
        int j; //used for the for loops
        
        //Calculate h value
        for (i = 0; i < patternLength - 1; i++) {
            h = (h * maxChar) % mod;
        }
        
        //Calculate the hash value for the pattern and first characters of the string 
        //according to patternLength value
        for (i = 0; i < patternLength; i++) {
            patternHash = (maxChar * patternHash + userPattern.charAt(i)) % mod;
            stringHash = (maxChar * stringHash + userString.charAt(i)) % mod;
        }
        
        //start sliding along the userString one by one
        for (i = 0; i <= (stringLength - patternLength); i++) {
            //check for same hash values in the current 'window' of text (same length as pattern)
            //If they match, start checking for characters one by one
            if (patternHash == stringHash) {
                //check for characters individual
                for (j = 0; j < patternLength; j++) {
                    if (userString.charAt(i + j) != userPattern.charAt(j)) {
                        break;
                    }
                }
                
                //if patternHash == stringHash
                if (j == patternLength) {
                    System.out.println("- There has been an instance of the pattern found at index " + i);
                }
            }
            
            //Continues searching by calculating hash value of next 'window' of text
            //also - removing the last digit (as it has been checked) and add a digit to the front
            if (i < stringLength - patternLength) {
                //sets the new string hash for the new window of text
                stringHash = (maxChar * (stringHash - userString.charAt(i) * h) 
                        + userString.charAt(i + patternLength)) % mod; 
                
                //if somehow stringHash becomes a negative number, convert it to a positive
                if (stringHash < 0) {
                    stringHash = (stringHash + mod);
                }
            }
        }
        
    }
        
    
}
