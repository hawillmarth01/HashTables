import java.util.Scanner;
import java.io.*;
public class HashTableDriver{
    public static void main(String args[]){
        //GENERAL HASH TABLE
        System.out.println("General Hash Table"); //label
        System.out.println();
        //create new general hash table
        GeneralHashTable generalHashTable = new GeneralHashTable();

        //retrieves a file from user: FROM TEXTSCAN.TXT (modified)
        Scanner readFile = null;
        String filename;

        //gets filename from user and checks for file, ends program if file not found 
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter file you would like to scan: "); 
        filename = inputScanner.nextLine();

        System.out.println();
        System.out.println("Attempting to read from file: " + filename);
        try {
            readFile = new Scanner(new File("data/" + filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + filename + " not found");
            System.exit(1);  
        }

        System.out.println("Connection to file: " + filename + " successful");
        System.out.println(); 

        //loop that reads from file and locates tokens: FROM TEXTSCAN.TXT, (modified)
        //each token found is added to general hash table
        int count = 0; //variable for total token count
        while (readFile.hasNext()) {
            String nextKey = readFile.next(); //next token found in file
            //System.out.println("key: " + nextKey); //TEST: prints token that is found
            
            count++; //increments total token count
            generalHashTable.addEntry(nextKey); //adds token to hash table
        }
        System.out.println(count + " Tokens found"); //prints the total number of tokens found in file
        System.out.println();
        
        //displays general hash table of file
        generalHashTable.display();
        System.out.println();

        //SPECIFIC HASH TABLE
        System.out.println("Specific Hash Table: keywords.txt"); //label
        
        //create new specific hash table for keywords.txt file
        SpecificHashTable specificHashTable = new SpecificHashTable();

        //retrieves a file from user: FROM TEXTSCAN.TXT (modified)
        Scanner readKeywordsFile = null;
        String specifiedFile;

        //file= keywords.txt, checks for file  
        specifiedFile = "data/keywords.txt"; //text file to read

        System.out.println();
        System.out.println("Attempting to read from file: " + specifiedFile);
        try {
            readKeywordsFile = new Scanner(new File(specifiedFile));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + specifiedFile + " not found");
            System.exit(1);  
        }

        System.out.println("Connection to file: " + specifiedFile + " successful");
        System.out.println(); 

        //loop that reads from file and locates tokens: FROM TEXTSCAN.TXT (modified)
        //each token found is added to specific hash table
        int count2 = 0; //variable for total token count
        while (readKeywordsFile.hasNext()) {
            String nextKey = readKeywordsFile.next(); //next token found in file
            count2 ++; //increments total token count
            specificHashTable.addEntry(nextKey); //adds token to hash table
            
        }
        System.out.println(count2 + " Tokens found"); //prints the total number of tokens found in file
        System.out.println();
        
        //display specifc hash table
        specificHashTable.display();
    }
}