import java.lang.Math;
public class GeneralHashTable{
    //instance variables
    public static int SIZE = 137; //hash table size
    public static Entry hashTable[]; //array to store hash table 

    //constructor, postCondition = new general hash table object, creates new array to store table
    public GeneralHashTable(){
        hashTable = new Entry[SIZE]; //creates new array for hash table

        //loop to set all inital values of hash table to null
        for (int i = 0; i < SIZE; i++){
            hashTable[i] = null; 
        }
    }
    //checks if table is empty, postCondition = returns boolean, true if table is empty 
    public boolean isEmpty(){
        //initializing boolean variables
        boolean stillChecking = true;
        boolean result = false; 

        while (stillChecking){
            for (int i = 0; i<SIZE; i++) {
                if (hashTable[i] != null){
                    result = false; //not empty
                    stillChecking = false; //exit loop
                }
            }
            result = true; //if reaches this point, all values in table are null, is empty
            stillChecking = false; 
        }
        return result;
    }

    //converts key to hash code, postCondition = returns key as hash code integer value
    public int hash(String key){
        int length = key.length(); //length of key
        String lowerKey = key.toLowerCase(); //convert key to lowercase
        
        //initializing variables
        int charVal; //value of specific character in key
        int firstCharVal = CharacterConversion.convertCharacter((lowerKey.charAt(0))); //value of first character in key
        int sum = 0; //sum of character values in key
        int hashCode; //final hash code value

        //loop that iterates through string
        for (int i = 0; i < length; i ++){
            char character = lowerKey.charAt(i);
            int convertChar = CharacterConversion.convertCharacter(character); //finds number value of character using character conversion class 
            //System.out.println(character+"-->"+convertChar);
            charVal = convertChar * (i+1); //character value = value of converted character * position in key (index + 1)
            
            sum += charVal; //add character value to sum   
        } 
        
        int notScaled = (sum * firstCharVal * length) + firstCharVal; //hash code
        hashCode = notScaled % SIZE; //scales hash code to size of table

        if (hashCode+1<SIZE && hashTable[hashCode+1]==null){ //if not @ end of table, check if the next index is empty
            hashCode += 1; //add one to index
        }

        //TEST: plug in values that have more than 6 tokens
        //if (hashCode == 107){ System.out.println("key is: " + key);System.out.println("sum is: " + sum);System.out.println("not scaled hash code is: " + notScaled);}
    
        return hashCode; //returns final hash code of key
    }

    //add method, postCondition = adds new entry to hash table 
    public void addEntry(String key){
        key = key.toLowerCase(); //convert key to lowercase
        Entry newEntry = new Entry(key); //creates new entry, ready to add
        
        //finds index using hash function
        int hashCode = hash(key); //hash code of key, (scaled to size of table in toHashCode method)

        //adds entry to table @ calculated hash code (index)
        if (hashTable[hashCode] == null){ //no entries currently at index --> add here
            hashTable[hashCode] = newEntry; 

            //TEST: plug in values that have more than 6 tokens
            //if (hashCode == 107){System.out.println("adding..." + key);}
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

                //TEST: plug in values that have more than 6 tokens
                //if (hashCode == 107){System.out.println("adding..." + key);}
            }
            //else, the key already exists, don't add again
        }
    }

    //display method, postCondition = displays the hash table (indexes w/ # of keys hashed to location)
    public void display(){
        System.out.println("HASH TABLE:"); //prints title

        int zeroCount = 0; //TEST: zero counter
        int moreThanSix = 0; //TEST: counts greater than 6
        
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
            
            //TEST: effectiveness of hash function- counts empty indexes and indexes with more than 6 tokens
            //if (tokenCount == 0){zeroCount += 1;} //add to zero count
            //if (tokenCount > 6){moreThanSix += 1;} //add to more than 6 count
        
            //display
            System.out.println(hashCode + ": " + tokenCount); //prints current index and count of entries in chain @ index 
        }
        //TEST: effectiveness of hash function- prints results
        //System.out.println("Number of zeros: " + zeroCount);
        //System.out.println("More than 6s: " + moreThanSix);
    }

    //TEST: hash table building algorithm
    public static void main(String [] args){
        //constructor
        GeneralHashTable table1 = new GeneralHashTable();
        
        //isEmpty
        System.out.println(table1.isEmpty());

        //converter
        //System.out.println(toHashCode("hello"));

        //adder
        table1.addEntry("hello"); //index 2 = null, adds hello at index 2
        table1.addEntry("goodbye"); //index2 != null, adds goodbye after hello at index 2
        table1.addEntry("hello"); //index2 != null, hello already in chain, don't add
        table1.addEntry("thank you"); //index2 != null, adds thank you after goodbye

        //getter
        //System.out.println(table1.getHashCode("hola"));

        //display
        table1.display();
    }
}