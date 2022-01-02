import java.lang.Math;
public class SpecificHashTable{
    //instance variables
    public static int SIZE = 50; //hash table size
    public static Entry hashTable[]; //array to store hash table 
    
    //constructor, postCondition = new specific hash table object, creates new array to store table
    public SpecificHashTable(){
        hashTable = new Entry[SIZE]; //creates new array for hash table

        //loop to set all inital values of hash table to null
        for (int i = 0; i < SIZE; i++){
            hashTable[i] = null; 
        }
    }

    //converts key to hash code, postCondition = returns key as hash code integer value
    public int hash(String key){ //specific to keywords hash table 
        //initializing variables
        int charVal; //value of specific character in key
        int sum = 0; //sum of character values in key
        int length = key.length(); //length of key

        //loop that iterates through string
        for (int i = 0; i < length; i ++){
            char character = key.charAt(i);
            int convertChar = CharacterConversion.convertCharacter(character); //finds number value of character using character conversion class 
            charVal = (convertChar * (i+1)) + (i+1); //character value = value of converted character * position in key (index + 1) + position in key
            
            sum += charVal; //add character value to sum   
        } 
        
        int hashCode = sum%SIZE; //inital hash code (sum), scaled down to size of table
        //if conditions that execute when collisions occur
        //each time collision occurs, slight change is made to sum of remaining elements
        if(hashTable[hashCode]!=null){ 
            hashCode = (sum+1)%SIZE;}
            if(hashTable[hashCode]!=null){
                hashCode = (sum+4)%SIZE;}
                if(hashTable[hashCode]!=null){
                    hashCode = (sum+6)%SIZE;}
                    if(hashTable[hashCode]!=null){
                        hashCode = (sum+8)%SIZE;}
                        if(hashTable[hashCode]!=null){
                            hashCode =(sum+12)%SIZE;}
                            if(hashTable[hashCode]!=null){
                                hashCode = 33;}//remaining index

        //TEST: plug in values that have more than 6 tokens
        //if (hashCode == 5){ System.out.println("key is: " + key);System.out.println("sum is: " + sum);System.out.println("hash code is: " + hashCode);}
    
        return hashCode; //returns final hash code of key
    }
    
    //add method, postCondition = adds new entry to hash table 
    public void addEntry(String key){
        Entry newEntry = new Entry(key); //creates new entry, ready to add
        
        //finds index using hash function
        int hashCode = hash(key); //hash code of key

        //adds entry to table @ calculated hash code (index)
        if (hashTable[hashCode] == null){ //no entries currently at index --> add here
            hashTable[hashCode] = newEntry; 
        }
        else{ //collision, add entry to chain @ index
            Entry currentEntry = hashTable[hashCode]; //first entry @ index
            
            //loop to find end of current chain @ index
            while (currentEntry.getNext() != null && !key.equals(currentEntry.getKey())){ //continue searching until the succeeding location is null (open) or the key of the current entry is the same as the new key
                currentEntry = currentEntry.getNext(); //go to next
            }
            //once exits loop, has either found location or key already exists
            if (!key.equals(currentEntry.getKey())){ //the next location in chain is null 
                currentEntry.setNext(newEntry); //adds new entry to end of chain @ index
            }
            //else, the key already exists, don't add again
        }
    }

    //display method, postCondition = displays the hash table (indexes w/ # of keys hashed to location)
    public void display(){ //specific to keywords hash table
        System.out.println("HASH TABLE:"); //prints title

        int zeroCount = 0; //TEST: zero counter
        int moreThanOne = 0; //TEST: counts greater than 1
        
        //loop that iterates through hash table
        for (int hashCode = 0; hashCode < SIZE; hashCode++){
            int tokenCount = 0; //initializes variable to keep track of # of keys hashed to specific index

            if (hashTable[hashCode]!= null){ //there is at least one key @ index
                Entry currentEntry = hashTable[hashCode]; //first entry @ index
                tokenCount = 1; //increment count for first entry @ index
            
                //loop that iterates through keys stored @ index, increments count until reaches null entry
                while (currentEntry.getNext() != null){
                    tokenCount += 1; //increments count
                    currentEntry = currentEntry.getNext(); //go to next
                }
                //null entry found, no more keys @ index, stop count
            }
            //else, the first entry is null, token count is 0. 
            
            //TEST: effectiveness of hash function- counts empty indexes and indexes with more than 1 token
            //if (tokenCount == 0){zeroCount += 1;} //add to zero count
            //if (tokenCount > 1){moreThanOne += 1;} //add to more than 6 count
        
            //display
            System.out.println(hashCode + ": " + tokenCount); //prints current index and count of entries in chain @ index 
        }
        //TEST: effectiveness of hash function- prints results
        //System.out.println("Number of zeros: " + zeroCount);
        //System.out.println("More than 1s: " + moreThanOne);
    }
    

    //TEST
    public static void main(String [] args){
       
    }
}