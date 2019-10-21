/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmatching;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author will2
 */
public class StringMatching {
    public String userString;
    public String userPattern;
    public Scanner scan;
    public int mod = 11; // a prime number
    private RabinKarp rabinKarp = RabinKarp.getInstance();
    
    StringMatching(){
        System.out.println(">Please enter a string you would like to get checked for patterns");
        scan = new Scanner(System.in);
        userString = scan.nextLine();
        
        System.out.println(">Please enter a string pattern you would like to search for");
        scan = new Scanner(System.in);
        userPattern = scan.nextLine();
        
        System.out.println(">You have choosen the string " + userString 
                + " and searching for pattern of " + userPattern);
        
        rabinKarp.RabinKarpSearch(userString, userPattern, mod);
    }
    
    public static void main(String[] args) {
        System.out.println("This is an implementation of the Rabin-Karp algorithm. "
                + "It is a string pattern matching algorithm that finds if and how many times a "
                + "\npattern is found in the given String. This is done through the use of hashing"
                + "technique and brute force comparisons.");
        
        StringMatching run = new StringMatching();
    }
    
}
