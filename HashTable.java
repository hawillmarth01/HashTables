public class HashTable{
    //instance variables
    private final int SIZE = 120; //Table size
    public Entry table[]; //array to store hash table 

    //constructor
    public HashTable(){
        table = new Entry[SIZE]; //creates new array for hash tab
    }

    //checks if table is empty
    public boolean isEmpty(){
        //checks if there is anything in hash table
        //returns true if nothing in hashtable, else returns false
    }
    //converts token/key to integer
    public int converter(String key){
        //takes in key or retrieves key value from entry
        //uses unicode to look up characters
        //returns value for key as integer
    }

    //gets value at key
    public String getValue(String key){
        //takes in token/key
        //using hash function, finds index for token
        //once at index, searches through list and finds token
        //then, gets value from entry 
        //returns this value
    }

    //adds entry to hashtable
    public void addEntry(String key, String value){
        //creates new entry
        //finds index using hashcode
        //if index here is null, insert at beginning of list
        //if not null, search list for token
            //if there, do nothing
            //if not, add entry to end of list 
    }

    //removes entry
    public void removeEntry(String key){
        //finds index using hashcode
        //if index is not null, find token within list
            //shift everything backward to remove from list
        //else, print error message
    }

}