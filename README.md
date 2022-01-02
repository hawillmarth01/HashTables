# Hash Table Implementations (Java)
### Code used to two different hash table/ function implementations.

## Summary
This repository includes hash table implementations for two different situations: general and specific. The 'general' implementation was built to handle unknown data whereas the 'specific' implementation was built with a known set of data in mind. The tokens for each hash table implementation are defined as any sequence of characters delimted by one or more white space characters.

## Test files
Five text files are included that can be run with the driver program:
* canterbury.txt
* gettysburg.txt
* proverbs.txt
* that_bad.txt
* keywords.txt *(used for 'specific' hash table implementation)*


## General Hash Table Implementation
* Size of table: 137 entries

### Hash Function Details
*For each key, hash function...*
1. Converts key to all lowercase.
2. Iterates through key, one character at a time. For each character:
    * Converts character to a numerical value using included character conversion class.
        > letters a-z, numbers 1-9, and common symbols, (,.') given values 1- 38
        > vowels and default (any other symbols) given values of primes from 37-59
    * Multiplies this numerical value by the character position in key (the index + 1). **This 
    is the final character value.**
3. Sums all values of characters in key.
4. Performs the following operations to get final hash code:
    * Product of: character sum, numerical value of first character, length of key
    * Addition of: numerical value of first character and product described above.
5. Scales hash code to size of table using modulo 137.
    * *Conditional: Checks hash table at hash code + 1 (index after current hash code). If it is
    empty, adds one to index (hash code value). If not, does nothing.*
6. Current hash code value is the final hash code (already scaled) of the specified key.

### Test Results
*For first four test files mentioned above:*
* No hash table index (i.e. the hash code) has more than six tokens "hashed" to it. 
* All hash tables except for table for 'gettysburg.txt' (shorter file, only has 266 tokens) are more than 90% full.

## Specific Hash Table Implementation
* Size of table: 50 entries
*Note: This is the smallest the hash table is able to be for the file "keywords.txt". There are 50 keywords, therefore if the table was any smaller, there would be collisions.*

### Hash Function Details
*For each key, hash function...*
1. Converts key to all lowercase.
2. Iterates through key, one character at a time. For each character:
    * Converts character to a numerical value using character conversion class, (same as described above).
    * Multiplies this numerical value by the character position in key (index + 1), then adds this position
    to the value. This is the final character value.
3. Sums all values of characters in key.
4. Scales initial hash code to size of table using modulo 50.
   *Collision conditionals:*
   * Every time there is a collision, a small change is made to the current hash code, (character sum) of
    the remaining characters, (each time scaling to the size of the table w/ %50).
   * This process continues until the specified key has a unique hash code.
5. Current hash code value is the final hash code (already scaled) of the specified key.

### Test Results
*For last test file ("keywords.txt") mentioned above:*
* All keys have a unique hash code and therefore map to a unique index, (every index contains one token).

## Output
By running driver file using commands below, both hash table implementations are displayed within terminal in the following format:
*location: # of tokens @ location*

## Usage
`javac HashTableDriver.java` <br>
`java HashTableDriver` <br> <br>
**Note: Will need to specify a test file (.txt file) for 'general' hash table implementation. "keywords.txt" is used for 'specific' hash table implementation by default.**

## Credits
Code used in "HashTableDriver.java" to scan a given text file is based of "TextScan.class" and "TextScan.java" which were provided for this project.

