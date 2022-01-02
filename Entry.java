//class for hash table entries, (nodes inserted at indexes in hast table array)
public class Entry {
	private Entry next; //variable for token after this entry in chain @ a certain index
	private String key; //variable for token found in file 

    //constructor
	public Entry(String key){
		this.key = key; 
		next = null;
    }
    
    //key getter, postCondition = returns key of entry at a certain location
	public String getKey(){ 
        return this.key;
    }

    //next getter, postCondition = returns entry after this entry in chain @ certain index
	public Entry getNext(){ 
        return this.next; 
    }

    //next setter, postCondition = sets next entry in chain @ certain index
	public void setNext(Entry nextEntry){ 
        this.next = nextEntry; 
    }
}